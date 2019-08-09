package com.dhirajgupta.currencies

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.dhirajgupta.currencies.api.CurrencyAPI
import com.dhirajgupta.currencies.db.CurrencyDatabase
import com.dhirajgupta.currencies.repository.CurrencyRepository
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import timber.log.Timber
import java.io.IOException
import java.util.concurrent.Executors

class CurrencyTests {

    lateinit var db: CurrencyDatabase
    lateinit var repository: CurrencyRepository

    @Rule
    @JvmField
    public var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun createDb() {
        Timber.plant(Timber.DebugTree())
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, CurrencyDatabase::class.java
        ).allowMainThreadQueries().build()
        repository = CurrencyRepository(db, CurrencyAPI.create(), Executors.newSingleThreadExecutor(), Executors.newSingleThreadExecutor())
        Timber.i("DB Set up")
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
        Timber.i("DB Torn Down")
    }

    @Test
    fun testRepository() {
        assertNull(repository.allCurrencies.value)
        assertNull(repository.chosenCurrency.value)
        //ToDo: Synchronous mock API calls and in-memory DB persistence through repository
//        repository.refreshCurrencies()
//        assertNotNull(repository.allCurrencies.value)
    }
}


