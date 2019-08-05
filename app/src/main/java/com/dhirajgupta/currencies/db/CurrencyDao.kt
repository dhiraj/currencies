package com.dhirajgupta.currencies.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dhirajgupta.currencies.model.KVPair
import com.dhirajgupta.currencies.model.OCurrency


/**
 * A DAO interface that will allow Room to work with the currency table
 */
@Dao
interface CurrencyDao {

    /**
     * Returns the [LiveData] wrapped [List] of [OCurrency] from the Room database. This is only used when the app
     * doesn't have a chosen currency, as a contingency case.
     */
    @Query("SELECT * from currency ORDER BY iso_code ASC")
    fun getAllCurrencies(): LiveData<List<OCurrency>>

    /**
     * The query that returns the [LiveData] wrapped [List] of [OCurrency] objects that are shown to the user
     * when a currency has been chosen. Note that the chosen currency is actually *filtered out* by the query
     * because it would otherwise be shown unnecessarily in the list.
     */
    @Query("SELECT * from currency WHERE iso_code != :not_iso_code ORDER BY iso_code ASC")
    fun getAllOtherCurrencies(not_iso_code: String): LiveData<List<OCurrency>>

    /**
     * Batch insert (or batch updates an existing) OCurrency into the Room database.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg currency: OCurrency)

    /**
     * The count of rows in the currency table. This is used as a check before selecting a default currency.
     */
    @Query("SELECT count(*) from currency")
    fun getCurrencyCount(): Int

    /**
     * Directly returns the chosen [OCurrency] wrapped in a [LiveData] so that Observers can be notified whenever
     * it changes.
     */
    @Query("SELECT * from currency where iso_code = (select v from kvpair where k = 'CHOSEN_ISO')")
    fun getChosenCurrency(): LiveData<OCurrency>


    /**
     * Returns the [KVPair] given a key
     */
    @Query("SELECT * from kvpair WHERE k = :k")
    fun getKVPair(k: String): LiveData<KVPair>

    /**
     * Standard Upsert function for [KVPair]
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(kvPair: KVPair)
}
