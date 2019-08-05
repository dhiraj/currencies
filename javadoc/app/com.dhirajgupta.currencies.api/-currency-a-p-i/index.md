[app](../../index.md) / [com.dhirajgupta.currencies.api](../index.md) / [CurrencyAPI](./index.md)

# CurrencyAPI

`interface CurrencyAPI`

Standard Retrofit / GSON API class to parse the response from the given API endpoints. Creates [OCurrency](../../com.dhirajgupta.currencies.model/-o-currency/index.md) objects
which will be saved by the [CurrencyRepository](#).

### Types

| Name | Summary |
|---|---|
| [CurrenciesResponse](-currencies-response/index.md) | `class CurrenciesResponse` |

### Functions

| Name | Summary |
|---|---|
| [getNames](get-names.md) | `abstract fun getNames(): Call<`[`CurrencyAPI.CurrenciesResponse`](-currencies-response/index.md)`>` |
| [getPrices](get-prices.md) | `abstract fun getPrices(): Call<`[`CurrencyAPI.CurrenciesResponse`](-currencies-response/index.md)`>` |

### Companion Object Functions

| Name | Summary |
|---|---|
| [create](create.md) | `fun create(): `[`CurrencyAPI`](./index.md)<br>`fun create(httpUrl: HttpUrl): `[`CurrencyAPI`](./index.md) |
