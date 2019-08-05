[app](../../index.md) / [com.dhirajgupta.currencies.fragment](../index.md) / [CurrencyListFragment](./index.md)

# CurrencyListFragment

`class CurrencyListFragment : Fragment`

Shows the list of all the currencies currently available along with the exchange rate for the chosen base currency

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CurrencyListFragment()`<br>Shows the list of all the currencies currently available along with the exchange rate for the chosen base currency |

### Properties

| Name | Summary |
|---|---|
| [autoFetchedCurrencyList](auto-fetched-currency-list.md) | `var autoFetchedCurrencyList: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>a flag to track if we have auto-fetched the currencies list from the [CurrencyAPI](#) in the initial state. Tracking this is required to prevent entering an indefinite loop of re-fetching in the case when no Internet is present in the initial state. |
| [networkStateObserver](network-state-observer.md) | `val networkStateObserver: Observer<`[`NetworkState`](../../com.dhirajgupta.currencies.model/-network-state/index.md)`!>`<br>Observer to update the swipe container refreshing status based on the [NetworkState](../../com.dhirajgupta.currencies.model/-network-state/index.md) |

### Functions

| Name | Summary |
|---|---|
| [currencyListAdapter](currency-list-adapter.md) | `fun currencyListAdapter(): `[`CurrencyListAdapter`](../../com.dhirajgupta.currencies.adapter/-currency-list-adapter/index.md)<br>Convenience function to return the [ListAdapter](#) typecasted the way we need it to be. |
| [onCreateOptionsMenu](on-create-options-menu.md) | `fun onCreateOptionsMenu(menu: `[`Menu`](https://developer.android.com/reference/android/view/Menu.html)`, inflater: `[`MenuInflater`](https://developer.android.com/reference/android/view/MenuInflater.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreateView](on-create-view.md) | `fun onCreateView(inflater: `[`LayoutInflater`](https://developer.android.com/reference/android/view/LayoutInflater.html)`, container: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`?, savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`View`](https://developer.android.com/reference/android/view/View.html)`?` |
| [onOptionsItemSelected](on-options-item-selected.md) | `fun onOptionsItemSelected(item: `[`MenuItem`](https://developer.android.com/reference/android/view/MenuItem.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Since we remove the chosen currency from the list, we need to have an Edit button so that the user can edit the amount more than once after selecting it. |
| [onViewCreated](on-view-created.md) | `fun onViewCreated(view: `[`View`](https://developer.android.com/reference/android/view/View.html)`, savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
