package com.dhirajgupta.currencies.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dhirajgupta.currencies.models.Currency


/**
 * The Room Database class that will manage the backing SQLite persistence database to the Currencies app
 */
@Database(entities = [Currency::class], version = 1)
abstract class CurrenciesDatabase: RoomDatabase() {

    /**
     * The main Currency DAO that will be used throughout the app
     */
    abstract fun currencyDao(): CurrencyDao


    companion object {
        @Volatile
        private var INSTANCE: CurrenciesDatabase? = null

        fun getDatabase(context: Context): CurrenciesDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CurrenciesDatabase::class.java,
                    "currencies_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}