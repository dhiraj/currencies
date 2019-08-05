[app](../index.md) / [com.dhirajgupta.currencies.model](./index.md)

## Package com.dhirajgupta.currencies.model

### Types

| Name | Summary |
|---|---|
| [KVPair](-k-v-pair/index.md) | `data class KVPair`<br>The [KVPair](-k-v-pair/index.md) model is used as a standard way for the app to persist any key value pair. Using a KVPair like this allows us to have the LiveData machinery supported through Room available to power the UI directly instead of resorting to clumsy SharedPreferences mechanisms. |
| [NetworkState](-network-state/index.md) | `data class NetworkState`<br>Copied from the [PagingWithNetwork](#) sample from https://github.com/googlesamples/android-architecture-components/tree/master/PagingWithNetworkSample Provides us a way to hook up the [SwipeRefreshLayout](#) to show spinning status while we're doing an API fetch |
| [OCurrency](-o-currency/index.md) | `data class OCurrency`<br>A model / room data class that will store data about a particular currency. The Name OCurrency is chosen to prevent mistaken conflicts with Java's Currency class. |
| [Status](-status/index.md) | `enum class Status` |

### Properties

| Name | Summary |
|---|---|
| [DEFAULT_CURRENCY_ISO](-d-e-f-a-u-l-t_-c-u-r-r-e-n-c-y_-i-s-o.md) | `const val DEFAULT_CURRENCY_ISO: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Constant for value of default currency that will be chosen in initial state. |
| [K_CHOSEN_CURRENCY](-k_-c-h-o-s-e-n_-c-u-r-r-e-n-c-y.md) | `const val K_CHOSEN_CURRENCY: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Constant for key against which the chosen country's ISO code is stored. |
