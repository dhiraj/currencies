package com.dhirajgupta.currencies.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dhirajgupta.currencies.App
import com.dhirajgupta.currencies.db.CurrenciesDatabase
import com.dhirajgupta.currencies.models.Currency
import com.dhirajgupta.currencies.models.CurrencyRepository
import timber.log.Timber

/**
 * The main view model of the Currencies app.
 */
class CurrencyViewModel: ViewModel() {
    private val repository:CurrencyRepository
    val allCurrencies: LiveData<List<Currency>>

    init {
        val currencyDao = CurrenciesDatabase.getDatabase(App.instance).currencyDao()
        repository = CurrencyRepository(currencyDao)
        allCurrencies = repository.allCurrencies
        Timber.i("CurrencyViewModel inited...")
    }
}