package com.dhirajgupta.currencies.repository

import androidx.annotation.WorkerThread
import com.dhirajgupta.currencies.api.CurrencyAPI
import com.dhirajgupta.currencies.db.CurrencyDao
import com.dhirajgupta.currencies.db.CurrencyDatabase
import com.dhirajgupta.currencies.model.Currency

/**
 * A Repository to provide centralized abstraction for access to currency data to the rest of the app
 * @param currencyDao The Currency Data Access Object class that will be used to work with Room Currency data*
 */
class CurrencyRepository(val db:CurrencyDatabase, private val api: CurrencyAPI) {

    /**
     *  Getter property that returns all the currencies that are currently available
     */
    val allCurrencies = db.currencyDao().getAllCurrencies()

    /**
     * Function to add a new currency into the system. Will mostly be called only from within?
     */
    @WorkerThread
    suspend fun insert(currency: Currency){
        db.currencyDao().insert(currency)
    }
}