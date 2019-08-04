package com.dhirajgupta.currencies.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dhirajgupta.currencies.App
import com.dhirajgupta.currencies.ServiceLocator
import com.dhirajgupta.currencies.model.OCurrency
import com.dhirajgupta.currencies.repository.CurrencyRepository
import timber.log.Timber

/**
 * The main view model of the Currencies app.
 */
class CurrencyViewModel: ViewModel() {
    private val repository: CurrencyRepository

    val allCurrencies: LiveData<List<OCurrency>>

    init {
        repository = ServiceLocator.instance(App.instance).getRepository()
        allCurrencies = repository.allCurrencies
        Timber.i("CurrencyViewModel inited...")
    }

    fun refreshCurrencies(){
        repository.refreshCurrencies()
    }
}