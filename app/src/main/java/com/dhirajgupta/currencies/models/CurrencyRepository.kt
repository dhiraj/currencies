package com.dhirajgupta.currencies.models

import androidx.annotation.WorkerThread
import com.dhirajgupta.currencies.db.CurrencyDao

/**
 * A Repository to provide centralized abstraction for access to currency data to the rest of the app
 * @param currencyDao The Currency Data Access Object class that will be used to work with Room Currency data*
 */
class CurrencyRepository(private val currencyDao:CurrencyDao) {

    /**
     *  Getter property that returns all the currencies that are currently available
     */
    val allCurrencies = currencyDao.getAllCurrencies()

    /**
     * Function to add a new currency into the system. Will mostly be called only from within?
     */
    @WorkerThread
    suspend fun insert(currency: Currency){
        currencyDao.insert(currency)
    }
}