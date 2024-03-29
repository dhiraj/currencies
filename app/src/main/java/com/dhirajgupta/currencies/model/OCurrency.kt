package com.dhirajgupta.currencies.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * A model / room data class that will store data about a particular currency.
 * The Name OCurrency is chosen to prevent mistaken conflicts with Java's Currency class.
 */
@Entity(tableName = "currency")
data class OCurrency(
    /**
     * The currency's 3 letter ISO code
     */
    @PrimaryKey(autoGenerate = false)
    val iso_code: String,

    /**
     * The full name of the currency
     */
    val name: String,

    /**
     * The current / last known price of the currency against 1 US Dollar
     */
    var price: Double = 0.toDouble()
)