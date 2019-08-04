package com.dhirajgupta.currencies.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dhirajgupta.currencies.api.CurrencyAPI
import com.dhirajgupta.currencies.db.CurrencyDatabase
import com.dhirajgupta.currencies.model.NetworkState
import com.dhirajgupta.currencies.model.OCurrency
import timber.log.Timber
import java.io.IOException
import java.util.concurrent.Executor

/**
 * A Repository to provide centralized abstraction for access to currency data to the rest of the app
 * @param currencyDao The OCurrency Data Access Object class that will be used to work with Room OCurrency data*
 */
class CurrencyRepository(val db:CurrencyDatabase, private val api: CurrencyAPI, val networkExecutor:Executor, val ioExecutor:Executor) {

    /**
     *  Getter property that returns all the currencies that are currently available
     */
    val allCurrencies = db.currencyDao().getAllCurrencies()

    fun refreshCurrencies():LiveData<NetworkState>{
        val networkState = MutableLiveData<NetworkState>()
        networkState.value = NetworkState.LOADING
        networkExecutor.execute {
            try {
//                Thread.sleep(1500)
                val namesResponse = api.getNames().execute()
                var body = namesResponse.body()
                if (!namesResponse.isSuccessful || body  == null){
                    throw RuntimeException("Could not get names response body!")
                }
                val names = body.currencies
                val pricesResponse = api.getPrices().execute()
                body = pricesResponse.body()
                if (!pricesResponse.isSuccessful || body == null){
                    throw java.lang.RuntimeException("Could not get prices response body!")
                }
                val prices = body.currencies
                val filled = names.zip(prices){name,quote ->
                    name.price = quote.price
                    return@zip name
                }.toTypedArray()
                ioExecutor.execute {
                    val currencyDao = db.currencyDao()
                    currencyDao.insertAll(*filled)
                }
                Timber.i("Upserted ${filled.size} currencies.")
                networkState.postValue(NetworkState.LOADED)
            }
            catch (ioe:IOException){
                Timber.e(ioe,"IOException Failed to get response!!!!")
                networkState.postValue(NetworkState.error(ioe.message))
            }
            catch (re:RuntimeException){
                Timber.e(re,"RuntimeException Failed to get response!!!!")
                networkState.postValue(NetworkState.error(re.message))
            }
        }
        return networkState
    }

    /**
     * Function to add a new currency into the system. Will mostly be called only from within?
     */
    @WorkerThread
    suspend fun insert(currency: OCurrency){
        db.currencyDao().insert(currency)
    }
}