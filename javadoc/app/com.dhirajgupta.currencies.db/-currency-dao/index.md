[app](../../index.md) / [com.dhirajgupta.currencies.db](../index.md) / [CurrencyDao](./index.md)

# CurrencyDao

`interface CurrencyDao`

A DAO interface that will allow Room to work with the currency table

### Functions

| Name | Summary |
|---|---|
| [getAllCurrencies](get-all-currencies.md) | `abstract fun getAllCurrencies(): LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`OCurrency`](../../com.dhirajgupta.currencies.model/-o-currency/index.md)`>>`<br>Returns the [LiveData](#) wrapped [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html) of [OCurrency](../../com.dhirajgupta.currencies.model/-o-currency/index.md) from the Room database. This is only used when the app doesn't have a chosen currency, as a contingency case. |
| [getAllOtherCurrencies](get-all-other-currencies.md) | `abstract fun getAllOtherCurrencies(not_iso_code: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`OCurrency`](../../com.dhirajgupta.currencies.model/-o-currency/index.md)`>>`<br>The query that returns the [LiveData](#) wrapped [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html) of [OCurrency](../../com.dhirajgupta.currencies.model/-o-currency/index.md) objects that are shown to the user when a currency has been chosen. Note that the chosen currency is actually *filtered out* by the query because it would otherwise be shown unnecessarily in the list. |
| [getChosenCurrency](get-chosen-currency.md) | `abstract fun getChosenCurrency(): LiveData<`[`OCurrency`](../../com.dhirajgupta.currencies.model/-o-currency/index.md)`>`<br>Directly returns the chosen [OCurrency](../../com.dhirajgupta.currencies.model/-o-currency/index.md) wrapped in a [LiveData](#) so that Observers can be notified whenever it changes. |
| [getCurrencyCount](get-currency-count.md) | `abstract fun getCurrencyCount(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The count of rows in the currency table. This is used as a check before selecting a default currency. |
| [getKVPair](get-k-v-pair.md) | `abstract fun getKVPair(k: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): LiveData<`[`KVPair`](../../com.dhirajgupta.currencies.model/-k-v-pair/index.md)`>`<br>Returns the [KVPair](../../com.dhirajgupta.currencies.model/-k-v-pair/index.md) given a key |
| [insert](insert.md) | `abstract fun insert(kvPair: `[`KVPair`](../../com.dhirajgupta.currencies.model/-k-v-pair/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Standard Upsert function for [KVPair](../../com.dhirajgupta.currencies.model/-k-v-pair/index.md) |
| [insertAll](insert-all.md) | `abstract fun insertAll(vararg currency: `[`OCurrency`](../../com.dhirajgupta.currencies.model/-o-currency/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Batch insert (or batch updates an existing) OCurrency into the Room database. |
