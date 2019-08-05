[app](../../index.md) / [com.dhirajgupta.currencies](../index.md) / [ServiceLocator](./index.md)

# ServiceLocator

`interface ServiceLocator`

Super simplified service locator implementation to allow us to replace default implementations
for testing.

### Functions

| Name | Summary |
|---|---|
| [getCurrencyApi](get-currency-api.md) | `abstract fun getCurrencyApi(): `[`CurrencyAPI`](../../com.dhirajgupta.currencies.api/-currency-a-p-i/index.md) |
| [getDiskIOExecutor](get-disk-i-o-executor.md) | `abstract fun getDiskIOExecutor(): `[`Executor`](https://developer.android.com/reference/java/util/concurrent/Executor.html) |
| [getNetworkExecutor](get-network-executor.md) | `abstract fun getNetworkExecutor(): `[`Executor`](https://developer.android.com/reference/java/util/concurrent/Executor.html) |
| [getRepository](get-repository.md) | `abstract fun getRepository(): `[`CurrencyRepository`](../../com.dhirajgupta.currencies.repository/-currency-repository/index.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [instance](instance.md) | `fun instance(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): `[`ServiceLocator`](./index.md) |
| [swap](swap.md) | `fun swap(locator: `[`ServiceLocator`](./index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Allows tests to replace the default implementations. |

### Inheritors

| Name | Summary |
|---|---|
| [DefaultServiceLocator](../-default-service-locator/index.md) | `open class DefaultServiceLocator : `[`ServiceLocator`](./index.md)<br>default implementation of ServiceLocator that uses production endpoints. |
