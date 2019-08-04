package com.dhirajgupta.currencies.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dhirajgupta.currencies.models.Currency


/**
 * A DAO interface that will allow Room to work with the currency table
 */
@Dao
interface CurrencyDao {

    /**
     * Returns the [LiveData] wrapped [List] of [Currency] from the Room database
     */
    @Query("SELECT * from currency ORDER BY iso_code ASC")
    fun getAllCurrencies(): LiveData<List<Currency>>

    /**
     * Adds a new (or updates an existing) Currency into the Room database
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(currency: Currency)

}