[app](../../index.md) / [com.dhirajgupta.currencies.repository](../index.md) / [CurrencyRepository](index.md) / [refreshCurrencies](./refresh-currencies.md)

# refreshCurrencies

`fun refreshCurrencies(): LiveData<`[`NetworkState`](../../com.dhirajgupta.currencies.model/-network-state/index.md)`>`

Perform network fetch to get both the Names and Prices of all currencies. We have chosen to perform sequential
fetch every time for both endpoints, because it lets us avoid the case where we know only the names, but not the
prices of all currencies. We also assume that each currency price and name are matched in both endpoints in both
ordering as well as pairing.

This will need to be updated when API support gives us more data about currencies, like historical data as well
and flags, currency symbols, etc. Showing the user information about network fetch errors has also been left
out, for now.

