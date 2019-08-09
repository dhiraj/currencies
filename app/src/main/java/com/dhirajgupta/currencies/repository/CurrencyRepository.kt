package com.dhirajgupta.currencies.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dhirajgupta.currencies.api.CurrencyAPI
import com.dhirajgupta.currencies.db.CurrencyDatabase
import com.dhirajgupta.currencies.model.KVPair
import com.dhirajgupta.currencies.model.K_CHOSEN_CURRENCY
import com.dhirajgupta.currencies.model.NetworkState
import com.dhirajgupta.currencies.model.OCurrency
import timber.log.Timber
import java.io.IOException
import java.util.concurrent.Executor

/**
 * A Repository to provide centralized abstraction for access to currency data to the rest of the app
 * @param db The instantiated [CurrencyDatabase] that will be used
 * @param api The instantiated [CurrencyAPI] that will be used
 * @param networkExecutor The instantiated [Executor] that will be used to make *synchronous* network calls
 * @param ioExecutor The instantiated [Executor] that will be used for any writing to the database.
 */
class CurrencyRepository(
    val db: CurrencyDatabase,
    private val api: CurrencyAPI,
    val networkExecutor: Executor,
    val ioExecutor: Executor
) {

    /**
     *  Getter property that returns all the currencies that are currently available. Used as contingency when chosen
     *  currency is not available
     */
    val allCurrencies = db.currencyDao().getAllCurrencies()

    /**
     * Observable currency that is currently chosen by the user (or by default)
     */
    val chosenCurrency = db.currencyDao().getChosenCurrency()

    /**
     * Return all currencies other than the one passed. If null currency is passed, then returns all currencies.
     */
    fun allCurrenciesOtherThan(currency: OCurrency?): LiveData<List<OCurrency>> {
        return when (currency) {
            null -> allCurrencies
            else -> db.currencyDao().getAllOtherCurrencies(currency.iso_code)
        }
    }

    /**
     * Perform network fetch to get both the Names and Prices of all currencies. We have chosen to perform sequential
     * fetch every time for both endpoints, because it lets us avoid the case where we know only the names, but not the
     * prices of all currencies. We also assume that each currency price and name are matched in both endpoints in both
     * ordering as well as pairing.
     *
     * This will need to be updated when API support gives us more data about currencies, like historical data as well
     * and flags, currency symbols, etc. Showing the user information about network fetch errors has also been left
     * out, for now.
     */
    fun refreshCurrencies(): LiveData<NetworkState> {
        val networkState = MutableLiveData<NetworkState>()
        networkState.value = NetworkState.LOADING
        networkExecutor.execute {
            try {
//                Thread.sleep(1500) //Uncomment to debug / see the [SwipeRefreshLayout] spinner
                val namesResponse = api.getNames().execute()
                var body = namesResponse.body()
                if (!namesResponse.isSuccessful || body == null) {
                    throw RuntimeException("Could not get names response body!")
                }
                val names = body.currencies
                val pricesResponse = api.getPrices().execute()
                body = pricesResponse.body()
                if (!pricesResponse.isSuccessful || body == null) {
                    throw java.lang.RuntimeException("Could not get prices response body!")
                }
                val prices = body.currencies
                /**
                 * Use the Kotlin Collections zip function to take price from the quote and get a single collection out.
                 * Note: *IMPORTANT* If the order or matching of the items in the two API endpoints goes out of sync
                 * then we will end up showing wrong information to the user.
                 */
                val filled = names.zip(prices) { name, quote ->
                    name.price = quote.price
                    return@zip name
                }.toTypedArray()
                ioExecutor.execute {
                    val currencyDao = db.currencyDao()
                    currencyDao.insertAll(*filled)
                }
                Timber.i("Upserted ${filled.size} currencies.")
                networkState.postValue(NetworkState.LOADED)
            } catch (ioe: IOException) {
                Timber.e(ioe, "IOException Failed to get response!!!!")
                networkState.postValue(NetworkState.error(ioe.message))
            } catch (re: RuntimeException) {
                Timber.e(re, "RuntimeException Failed to get response!!!!")
                networkState.postValue(NetworkState.error(re.message))
            }
        }
        return networkState
    }

    /**
     * Set the chosen currency upon user action or by default. Check that currencies actually exist in the db
     * before proceeding.
     */
    fun chooseCurrencyWithSymbol(iso_code: String) {
        ioExecutor.execute {
            if (db.currencyDao().getCurrencyCount() == 0) {
                Timber.w("Cannot set default currency because there aren't any in the DB, waiting for refresh from Net...")
                return@execute
            }
            db.currencyDao().insert(KVPair(K_CHOSEN_CURRENCY, iso_code))
        }
    }
}