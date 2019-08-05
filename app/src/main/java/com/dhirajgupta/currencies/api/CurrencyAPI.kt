package com.dhirajgupta.currencies.api

import com.dhirajgupta.currencies.model.OCurrency
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Standard Retrofit / GSON API class to parse the response from the given API endpoints. Creates [OCurrency] objects
 * which will be saved by the [CurrencyRepository].
 */
interface CurrencyAPI {
    @GET("names.json")
    fun getNames(): Call<CurrenciesResponse>

    @GET("prices.json")
    fun getPrices(): Call<CurrenciesResponse>

    class CurrenciesResponse(val currencies:List<OCurrency>)

    companion object {
        private const val BASE_URL = "https://storage.googleapis.com/public-static-artifacts/currencies/"
        fun create(): CurrencyAPI = create(HttpUrl.parse(BASE_URL)!!)
        fun create(httpUrl: HttpUrl): CurrencyAPI {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BASIC

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
            return Retrofit.Builder()
                .baseUrl(httpUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CurrencyAPI::class.java)
        }
    }
}