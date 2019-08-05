package com.dhirajgupta.currencies.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "kvpair")
data class KVPair (
    @PrimaryKey(autoGenerate = false)
    val k:String,
    val v:String
)

const val K_CHOSEN_CURRENCY = "CHOSEN_ISO"
const val K_CHOSEN_AMOUNT = "CHOSEN_AMOUNT"

const val DEFAULT_CURRENCY_ISO = "CAD"