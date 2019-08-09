package com.dhirajgupta.currencies.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * The [KVPair] model is used as a standard way for the app to persist any key value pair. Using a KVPair like this
 * allows us to have the LiveData machinery supported through Room available to power the UI directly instead of
 * resorting to clumsy SharedPreferences mechanisms.
 */
@Entity(tableName = "kvpair")
data class KVPair (
    @PrimaryKey(autoGenerate = false)
    val k:String,
    val v:String
)

/**
 * Constant for key against which the chosen country's ISO code is stored.
 */
const val K_CHOSEN_CURRENCY = "CHOSEN_ISO"

/**
 * Constant for value of default currency that will be chosen in initial state.
 */
const val DEFAULT_CURRENCY_ISO = "CAD"