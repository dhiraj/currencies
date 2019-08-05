package com.dhirajgupta.currencies.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dhirajgupta.currencies.model.KVPair
import com.dhirajgupta.currencies.model.OCurrency


/**
 * The Room Database class that will manage the backing SQLite persistence database to the Currencies app.
 */
@Database(entities = [OCurrency::class, KVPair::class], version = 1)
abstract class CurrencyDatabase: RoomDatabase() {

    /**
     * The main OCurrency DAO that will be used throughout the app
     */
    abstract fun currencyDao(): CurrencyDao


    companion object {
        fun create(context: Context, useInMemory : Boolean): CurrencyDatabase {
            val databaseBuilder = if(useInMemory) {
                Room.inMemoryDatabaseBuilder(context, CurrencyDatabase::class.java)
            } else {
                Room.databaseBuilder(context, CurrencyDatabase::class.java, "currencies.db")
            }
            return databaseBuilder
                .build()
        }
    }
}