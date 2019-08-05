package com.dhirajgupta.currencies.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dhirajgupta.currencies.App
import com.dhirajgupta.currencies.ServiceLocator
import com.dhirajgupta.currencies.model.KVPair
import com.dhirajgupta.currencies.model.NetworkState
import com.dhirajgupta.currencies.model.OCurrency
import com.dhirajgupta.currencies.repository.CurrencyRepository
import timber.log.Timber

/**
 * The main view model of the Currencies app.
 */
class CurrencyViewModel: ViewModel() {
    private val repository: CurrencyRepository
    var currentScreenTitle: MutableLiveData<String> = MutableLiveData()

    val allCurrencies: LiveData<List<OCurrency>>
    val chosenCurrency: LiveData<OCurrency>

    init {
        repository = ServiceLocator.instance(App.instance).getRepository()
        allCurrencies = repository.allCurrencies
        chosenCurrency = repository.chosenCurrency
        Timber.i("CurrencyViewModel inited...")
    }

    fun refreshCurrencies():LiveData<NetworkState>{
        return repository.refreshCurrencies()
    }

    fun chooseCurrency(iso_code:String){
        repository.chooseCurrencyWithSymbol(iso_code)
    }

}