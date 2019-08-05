[app](../index.md) / [com.dhirajgupta.currencies.adapter](./index.md)

## Package com.dhirajgupta.currencies.adapter

### Types

| Name | Summary |
|---|---|
| [CurrencyListAdapter](-currency-list-adapter/index.md) | `class CurrencyListAdapter : ListAdapter<`[`OCurrency`](../com.dhirajgupta.currencies.model/-o-currency/index.md)`, `[`CurrencyListAdapter.CurrencyViewHolder`](-currency-list-adapter/-currency-view-holder/index.md)`>`<br>[ListAdapter](#) subclass that allows us to adapt our [OCurrency](../com.dhirajgupta.currencies.model/-o-currency/index.md) model to be presented to the user in a [RecyclerView](#) Fairly, standard and straightforward implementation that calculates the conversion quote given the chosen currency and the amount to be converted. |
| [OCurrencyDiffCallback](-o-currency-diff-callback/index.md) | `class OCurrencyDiffCallback : ItemCallback<`[`OCurrency`](../com.dhirajgupta.currencies.model/-o-currency/index.md)`>`<br>Standard [DiffUtil.Callback](#) subclass to allow faster updates when the user's chosen currency or amount changes, or when the [CurrencyApi](#) returns updated results. |
