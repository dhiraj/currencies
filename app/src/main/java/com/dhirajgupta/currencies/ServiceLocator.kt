/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dhirajgupta.currencies

import android.app.Application
import android.content.Context
import androidx.annotation.VisibleForTesting
import com.dhirajgupta.currencies.api.CurrencyAPI
import com.dhirajgupta.currencies.db.CurrencyDatabase
import com.dhirajgupta.currencies.repository.CurrencyRepository
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * Super simplified service locator implementation to allow us to replace default implementations
 * for testing.
 * 
 */
interface ServiceLocator {
    companion object {
        private val LOCK = Any()
        private var instance: ServiceLocator? = null
        fun instance(context: Context): ServiceLocator {
            synchronized(LOCK) {
                if (instance == null) {
                    instance = DefaultServiceLocator(
                            app = context.applicationContext as Application,
                            useInMemoryDb = false)
                }
                return instance!!
            }
        }

        /**
         * Allows tests to replace the default implementations.
         */
        @VisibleForTesting
        fun swap(locator: ServiceLocator) {
            instance = locator
        }
    }

    fun getRepository(): CurrencyRepository

    fun getNetworkExecutor(): Executor

    fun getDiskIOExecutor(): Executor

    fun getCurrencyApi(): CurrencyAPI
}

/**
 * default implementation of ServiceLocator that uses production endpoints.
 */
open class DefaultServiceLocator(val app: Application, val useInMemoryDb: Boolean) : ServiceLocator {
    // thread pool used for disk access
    @Suppress("PrivatePropertyName")
    private val DISK_IO = Executors.newSingleThreadExecutor()

    // thread pool used for network requests
    @Suppress("PrivatePropertyName")
    private val NETWORK_IO = Executors.newFixedThreadPool(5)

    private val db by lazy {
        CurrencyDatabase.create(app, useInMemoryDb)
    }

    private val api by lazy {
        CurrencyAPI.create()
    }

    override fun getRepository(): CurrencyRepository {
        return CurrencyRepository(db,api,NETWORK_IO,DISK_IO)
//        return when (type) {
//            RedditPostRepository.Type.IN_MEMORY_BY_ITEM -> InMemoryByItemRepository(
//                    redditApi = getRedditApi(),
//                    networkExecutor = getNetworkExecutor())
//            RedditPostRepository.Type.IN_MEMORY_BY_PAGE -> InMemoryByPageKeyRepository(
//                    redditApi = getRedditApi(),
//                    networkExecutor = getNetworkExecutor())
//            RedditPostRepository.Type.DB -> DbRedditPostRepository(
//                    db = db,
//                    redditApi = getRedditApi(),
//                    ioExecutor = getDiskIOExecutor())
//        }
    }

    override fun getNetworkExecutor(): Executor = NETWORK_IO

    override fun getDiskIOExecutor(): Executor = DISK_IO

    override fun getCurrencyApi(): CurrencyAPI = api
}