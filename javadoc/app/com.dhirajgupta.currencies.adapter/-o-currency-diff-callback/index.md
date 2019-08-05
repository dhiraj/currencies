[app](../../index.md) / [com.dhirajgupta.currencies.adapter](../index.md) / [OCurrencyDiffCallback](./index.md)

# OCurrencyDiffCallback

`class OCurrencyDiffCallback : ItemCallback<`[`OCurrency`](../../com.dhirajgupta.currencies.model/-o-currency/index.md)`>`

Standard [DiffUtil.Callback](#) subclass to allow faster updates when the user's chosen currency or amount changes, or
when the [CurrencyApi](#) returns updated results.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `OCurrencyDiffCallback()`<br>Standard [DiffUtil.Callback](#) subclass to allow faster updates when the user's chosen currency or amount changes, or when the [CurrencyApi](#) returns updated results. |

### Functions

| Name | Summary |
|---|---|
| [areContentsTheSame](are-contents-the-same.md) | `fun areContentsTheSame(oldItem: `[`OCurrency`](../../com.dhirajgupta.currencies.model/-o-currency/index.md)`, newItem: `[`OCurrency`](../../com.dhirajgupta.currencies.model/-o-currency/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>All the properties of the [OCurrency](../../com.dhirajgupta.currencies.model/-o-currency/index.md) object are compared to ensure that they are indeed the same object and don't need to be redrawn. |
| [areItemsTheSame](are-items-the-same.md) | `fun areItemsTheSame(oldItem: `[`OCurrency`](../../com.dhirajgupta.currencies.model/-o-currency/index.md)`, newItem: `[`OCurrency`](../../com.dhirajgupta.currencies.model/-o-currency/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>[OCurrency](../../com.dhirajgupta.currencies.model/-o-currency/index.md) iso_code is the object's primary key in Room and is a prime candidate to determine if two items are the same. |
