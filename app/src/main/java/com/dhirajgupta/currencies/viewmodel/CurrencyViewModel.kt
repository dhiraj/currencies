package com.dhirajgupta.currencies.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.dhirajgupta.currencies.App
import com.dhirajgupta.currencies.ServiceLocator
import com.dhirajgupta.currencies.model.KVPair
import com.dhirajgupta.currencies.model.NetworkState
import com.dhirajgupta.currencies.model.OCurrency
import com.dhirajgupta.currencies.repository.CurrencyRepository
import timber.log.Timber

/**
 * The main view model of the Currencies app. Shared across the [MainActivity] as well as by both [CurrencyListFragment]
 * and [AmountInputFragment].
 *
 * @param repository: The [CurrencyRepository]'s instance is fetched from the app [ServiceLocator] on startup
 * @param chosenCurrency: The chosen [OCurrency] is directly mapped to the [CurrencyRepository] value, on init
 * @param currencyList: The list of [OCurrency] that is displayed to the user. Updated using switchMap whenever the
 * [chosenCurrency] changes by fetching the updated list for the chosen currency from the repository.
 * @param amount: The user's inputted amount. This is lost on app startup, but it can be easily persisted using our
 * standard [KVPair] mechanism.
 */
class CurrencyViewModel : ViewModel() {
    private val repository: CurrencyRepository
    var currentScreenTitle: MutableLiveData<String> = MutableLiveData()

    val chosenCurrency: LiveData<OCurrency>
    val currencyList: LiveData<List<OCurrency>>
    var amount:MutableLiveData<Double> = MutableLiveData()

    init {
        amount.value = 1.toDouble()
        repository = ServiceLocator.instance(App.instance).getRepository()
        chosenCurrency = repository.chosenCurrency
        currencyList = Transformations.switchMap(chosenCurrency) { chosen -> repository.allCurrenciesOtherThan(chosen) }
        Timber.i("CurrencyViewModel inited...")
    }

    /**
     * Forward the call to the repository
     */
    fun refreshCurrencies(): LiveData<NetworkState> {
        return repository.refreshCurrencies()
    }

    /**
     * Forward the call to the repository
     */
    fun chooseCurrency(iso_code: String) {
        repository.chooseCurrencyWithSymbol(iso_code)
    }

}