[app](../../index.md) / [com.dhirajgupta.currencies.viewmodel](../index.md) / [CurrencyViewModel](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`CurrencyViewModel()`

The main view model of the Currencies app. Shared across the [MainActivity](#) as well as by both [CurrencyListFragment](#)
and [AmountInputFragment](#).

### Parameters

`repository` - : The [CurrencyRepository](../../com.dhirajgupta.currencies.repository/-currency-repository/index.md)'s instance is fetched from the app [ServiceLocator](../../com.dhirajgupta.currencies/-service-locator/index.md) on startup

`chosenCurrency` - : The chosen [OCurrency](../../com.dhirajgupta.currencies.model/-o-currency/index.md) is directly mapped to the [CurrencyRepository](../../com.dhirajgupta.currencies.repository/-currency-repository/index.md) value, on init

`currencyList` - : The list of [OCurrency](../../com.dhirajgupta.currencies.model/-o-currency/index.md) that is displayed to the user. Updated using switchMap whenever the
[chosenCurrency](chosen-currency.md) changes by fetching the updated list for the chosen currency from the repository.

`amount` - : The user's inputted amount. This is lost on app startup, but it can be easily persisted using our
standard [KVPair](../../com.dhirajgupta.currencies.model/-k-v-pair/index.md) mechanism.