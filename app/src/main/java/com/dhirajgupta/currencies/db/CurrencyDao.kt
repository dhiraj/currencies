package com.dhirajgupta.currencies.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
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

    /**
     * Adds a new (or updates an existing) OCurrency into the Room database
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(currency: OCurrency)

    /**
     * Batch insers (or batch updates an existing) OCurrency into the Room database
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg currency: OCurrency)

}
