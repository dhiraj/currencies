[app](../../index.md) / [com.dhirajgupta.currencies.repository](../index.md) / [CurrencyRepository](./index.md)

# CurrencyRepository

`class CurrencyRepository`

A Repository to provide centralized abstraction for access to currency data to the rest of the app

### Parameters

`db` - The instantiated [CurrencyDatabase](../../com.dhirajgupta.currencies.db/-currency-database/index.md) that will be used

`api` - The instantiated [CurrencyAPI](../../com.dhirajgupta.currencies.api/-currency-a-p-i/index.md) that will be used

`networkExecutor` - The instantiated [Executor](https://developer.android.com/reference/java/util/concurrent/Executor.html) that will be used to make *synchronous* network calls

`ioExecutor` - The instantiated [Executor](https://developer.android.com/reference/java/util/concurrent/Executor.html) that will be used for any writing to the database.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CurrencyRepository(db: `[`CurrencyDatabase`](../../com.dhirajgupta.currencies.db/-currency-database/index.md)`, api: `[`CurrencyAPI`](../../com.dhirajgupta.currencies.api/-currency-a-p-i/index.md)`, networkExecutor: `[`Executor`](https://developer.android.com/reference/java/util/concurrent/Executor.html)`, ioExecutor: `[`Executor`](https://developer.android.com/reference/java/util/concurrent/Executor.html)`)`<br>A Repository to provide centralized abstraction for access to currency data to the rest of the app |

### Properties

| Name | Summary |
|---|---|
| [allCurrencies](all-currencies.md) | `val allCurrencies: LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`OCurrency`](../../com.dhirajgupta.currencies.model/-o-currency/index.md)`>>`<br>Getter property that returns all the currencies that are currently available. Used as contingency when chosen currency is not available |
| [chosenCurrency](chosen-currency.md) | `val chosenCurrency: LiveData<`[`OCurrency`](../../com.dhirajgupta.currencies.model/-o-currency/index.md)`>`<br>Observable currency that is currently chosen by the user (or by default) |
| [db](db.md) | `val db: `[`CurrencyDatabase`](../../com.dhirajgupta.currencies.db/-currency-database/index.md)<br>The instantiated [CurrencyDatabase](../../com.dhirajgupta.currencies.db/-currency-database/index.md) that will be used |
| [ioExecutor](io-executor.md) | `val ioExecutor: `[`Executor`](https://developer.android.com/reference/java/util/concurrent/Executor.html)<br>The instantiated [Executor](https://developer.android.com/reference/java/util/concurrent/Executor.html) that will be used for any writing to the database. |
| [networkExecutor](network-executor.md) | `val networkExecutor: `[`Executor`](https://developer.android.com/reference/java/util/concurrent/Executor.html)<br>The instantiated [Executor](https://developer.android.com/reference/java/util/concurrent/Executor.html) that will be used to make *synchronous* network calls |

### Functions

| Name | Summary |
|---|---|
| [allCurrenciesOtherThan](all-currencies-other-than.md) | `fun allCurrenciesOtherThan(currency: `[`OCurrency`](../../com.dhirajgupta.currencies.model/-o-currency/index.md)`?): LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`OCurrency`](../../com.dhirajgupta.currencies.model/-o-currency/index.md)`>>`<br>Return all currencies other than the one passed. If null currency is passed, then returns all currencies. |
| [chooseCurrencyWithSymbol](choose-currency-with-symbol.md) | `fun chooseCurrencyWithSymbol(iso_code: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Set the chosen currency upon user action or by default. Check that currencies actually exist in the db before proceeding. |
| [refreshCurrencies](refresh-currencies.md) | `fun refreshCurrencies(): LiveData<`[`NetworkState`](../../com.dhirajgupta.currencies.model/-network-state/index.md)`>`<br>Perform network fetch to get both the Names and Prices of all currencies. We have chosen to perform sequential fetch every time for both endpoints, because it lets us avoid the case where we know only the names, but not the prices of all currencies. We also assume that each currency price and name are matched in both endpoints in both ordering as well as pairing. |
