[app](../../index.md) / [com.dhirajgupta.currencies.adapter](../index.md) / [CurrencyListAdapter](./index.md)

# CurrencyListAdapter

`class CurrencyListAdapter : ListAdapter<`[`OCurrency`](../../com.dhirajgupta.currencies.model/-o-currency/index.md)`, `[`CurrencyListAdapter.CurrencyViewHolder`](-currency-view-holder/index.md)`>`

[ListAdapter](#) subclass that allows us to adapt our [OCurrency](../../com.dhirajgupta.currencies.model/-o-currency/index.md) model to be presented to the user in a [RecyclerView](#)
Fairly, standard and straightforward implementation that calculates the conversion quote given the chosen currency
and the amount to be converted.

### Types

| Name | Summary |
|---|---|
| [CurrencyViewHolder](-currency-view-holder/index.md) | `inner class CurrencyViewHolder : ViewHolder` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CurrencyListAdapter()`<br>[ListAdapter](#) subclass that allows us to adapt our [OCurrency](../../com.dhirajgupta.currencies.model/-o-currency/index.md) model to be presented to the user in a [RecyclerView](#) Fairly, standard and straightforward implementation that calculates the conversion quote given the chosen currency and the amount to be converted. |

### Properties

| Name | Summary |
|---|---|
| [amount](amount.md) | `var amount: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)<br>the adapter needs to be notified whenever the user's chosen amount is changed. |
| [chosenCurrency](chosen-currency.md) | `var chosenCurrency: `[`OCurrency`](../../com.dhirajgupta.currencies.model/-o-currency/index.md)`?`<br>the adapter needs to be notified whenever the user's chosen currency is changed. |
| [clicked](clicked.md) | `var clicked: ((`[`OCurrency`](../../com.dhirajgupta.currencies.model/-o-currency/index.md)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`)?`<br>the adapter will pass on clicks detected to its intended consumer, [CurrencyListFragment](#) through this function, and pass the user-tapped [OCurrency](../../com.dhirajgupta.currencies.model/-o-currency/index.md) model along in the function invocation. |

### Functions

| Name | Summary |
|---|---|
| [onBindViewHolder](on-bind-view-holder.md) | `fun onBindViewHolder(holder: `[`CurrencyListAdapter.CurrencyViewHolder`](-currency-view-holder/index.md)`, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreateViewHolder](on-create-view-holder.md) | `fun onCreateViewHolder(parent: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`, viewType: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`CurrencyListAdapter.CurrencyViewHolder`](-currency-view-holder/index.md) |
