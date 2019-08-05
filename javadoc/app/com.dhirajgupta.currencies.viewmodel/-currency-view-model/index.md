[app](../../index.md) / [com.dhirajgupta.currencies.viewmodel](../index.md) / [CurrencyViewModel](./index.md)

# CurrencyViewModel

`class CurrencyViewModel : ViewModel`

The main view model of the Currencies app. Shared across the [MainActivity](#) as well as by both [CurrencyListFragment](#)
and [AmountInputFragment](#).

### Parameters

`repository` - : The [CurrencyRepository](../../com.dhirajgupta.currencies.repository/-currency-repository/index.md)'s instance is fetched from the app [ServiceLocator](../../com.dhirajgupta.currencies/-service-locator/index.md) on startup

`chosenCurrency` - : The chosen [OCurrency](../../com.dhirajgupta.currencies.model/-o-currency/index.md) is directly mapped to the [CurrencyRepository](../../com.dhirajgupta.currencies.repository/-currency-repository/index.md) value, on init

`currencyList` - : The list of [OCurrency](../../com.dhirajgupta.currencies.model/-o-currency/index.md) that is displayed to the user. Updated using switchMap whenever the
[chosenCurrency](chosen-currency.md) changes by fetching the updated list for the chosen currency from the repository.

`amount` - : The user's inputted amount. This is lost on app startup, but it can be easily persisted using our
standard [KVPair](../../com.dhirajgupta.currencies.model/-k-v-pair/index.md) mechanism.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CurrencyViewModel()`<br>The main view model of the Currencies app. Shared across the [MainActivity](#) as well as by both [CurrencyListFragment](#) and [AmountInputFragment](#). |

### Properties

| Name | Summary |
|---|---|
| [amount](amount.md) | `var amount: MutableLiveData<`[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`>` |
| [chosenCurrency](chosen-currency.md) | `val chosenCurrency: LiveData<`[`OCurrency`](../../com.dhirajgupta.currencies.model/-o-currency/index.md)`>` |
| [currencyList](currency-list.md) | `val currencyList: LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`OCurrency`](../../com.dhirajgupta.currencies.model/-o-currency/index.md)`>>` |
| [currentScreenTitle](current-screen-title.md) | `var currentScreenTitle: MutableLiveData<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |

### Functions

| Name | Summary |
|---|---|
| [chooseCurrency](choose-currency.md) | `fun chooseCurrency(iso_code: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Forward the call to the repository |
| [refreshCurrencies](refresh-currencies.md) | `fun refreshCurrencies(): LiveData<`[`NetworkState`](../../com.dhirajgupta.currencies.model/-network-state/index.md)`>`<br>Forward the call to the repository |
