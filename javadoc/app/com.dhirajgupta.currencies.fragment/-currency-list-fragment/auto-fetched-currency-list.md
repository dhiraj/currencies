[app](../../index.md) / [com.dhirajgupta.currencies.fragment](../index.md) / [CurrencyListFragment](index.md) / [autoFetchedCurrencyList](./auto-fetched-currency-list.md)

# autoFetchedCurrencyList

`var autoFetchedCurrencyList: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

a flag to track if we have auto-fetched the currencies list from the [CurrencyAPI](#) in the initial state. Tracking
this is required to prevent entering an indefinite loop of re-fetching in the case when no Internet is present
in the initial state.

