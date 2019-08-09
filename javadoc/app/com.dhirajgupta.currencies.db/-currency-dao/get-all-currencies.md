[app](../../index.md) / [com.dhirajgupta.currencies.db](../index.md) / [CurrencyDao](index.md) / [getAllCurrencies](./get-all-currencies.md)

# getAllCurrencies

`abstract fun getAllCurrencies(): LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`OCurrency`](../../com.dhirajgupta.currencies.model/-o-currency/index.md)`>>`

Returns the [LiveData](#) wrapped [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html) of [OCurrency](../../com.dhirajgupta.currencies.model/-o-currency/index.md) from the Room database. This is only used when the app
doesn't have a chosen currency, as a contingency case.

