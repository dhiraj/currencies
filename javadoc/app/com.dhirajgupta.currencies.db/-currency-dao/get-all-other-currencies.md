[app](../../index.md) / [com.dhirajgupta.currencies.db](../index.md) / [CurrencyDao](index.md) / [getAllOtherCurrencies](./get-all-other-currencies.md)

# getAllOtherCurrencies

`abstract fun getAllOtherCurrencies(not_iso_code: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`OCurrency`](../../com.dhirajgupta.currencies.model/-o-currency/index.md)`>>`

The query that returns the [LiveData](#) wrapped [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html) of [OCurrency](../../com.dhirajgupta.currencies.model/-o-currency/index.md) objects that are shown to the user
when a currency has been chosen. Note that the chosen currency is actually *filtered out* by the query
because it would otherwise be shown unnecessarily in the list.

