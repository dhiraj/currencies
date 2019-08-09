[app](../../index.md) / [com.dhirajgupta.currencies.model](../index.md) / [NetworkState](./index.md)

# NetworkState

`data class NetworkState`

Copied from the [PagingWithNetwork](#) sample from https://github.com/googlesamples/android-architecture-components/tree/master/PagingWithNetworkSample
Provides us a way to hook up the [SwipeRefreshLayout](#) to show spinning status while we're doing an API fetch

### Properties

| Name | Summary |
|---|---|
| [msg](msg.md) | `val msg: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [status](status.md) | `val status: `[`Status`](../-status/index.md) |

### Companion Object Properties

| Name | Summary |
|---|---|
| [LOADED](-l-o-a-d-e-d.md) | `val LOADED: `[`NetworkState`](./index.md) |
| [LOADING](-l-o-a-d-i-n-g.md) | `val LOADING: `[`NetworkState`](./index.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [error](error.md) | `fun error(msg: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`NetworkState`](./index.md) |
