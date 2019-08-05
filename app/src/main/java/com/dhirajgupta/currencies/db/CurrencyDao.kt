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
     * Returns the [LiveData] wrapped [List] of [OCurrency] from the Room database
     */
    @Query("SELECT * from currency ORDER BY iso_code ASC")
    fun getAllCurrencies(): LiveData<List<OCurrency>>

    @Query("SELECT * from currency WHERE iso_code != :not_iso_code ORDER BY iso_code ASC")
    fun getAllOtherCurrencies(not_iso_code: String): LiveData<List<OCurrency>>

    /**
     * Batch insers (or batch updates an existing) OCurrency into the Room database
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg currency: OCurrency)

    @Query("SELECT * from kvpair WHERE k = :k")
    fun getKVPair(k: String): LiveData<KVPair>

    @Query("SELECT * from currency where iso_code = (select v from kvpair where k = 'CHOSEN_ISO')")
    fun getChosenCurrency(): LiveData<OCurrency>


    @Query("SELECT count(*) from currency")
    fun getCurrencyCount(): Int


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(kvPair: KVPair)
}
