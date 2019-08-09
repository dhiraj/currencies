[app](../../index.md) / [com.dhirajgupta.currencies](../index.md) / [DefaultServiceLocator](./index.md)

# DefaultServiceLocator

`open class DefaultServiceLocator : `[`ServiceLocator`](../-service-locator/index.md)

default implementation of ServiceLocator that uses production endpoints.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `DefaultServiceLocator(app: `[`Application`](https://developer.android.com/reference/android/app/Application.html)`, useInMemoryDb: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`)`<br>default implementation of ServiceLocator that uses production endpoints. |

### Properties

| Name | Summary |
|---|---|
| [app](app.md) | `val app: `[`Application`](https://developer.android.com/reference/android/app/Application.html) |
| [useInMemoryDb](use-in-memory-db.md) | `val useInMemoryDb: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

### Functions

| Name | Summary |
|---|---|
| [getCurrencyApi](get-currency-api.md) | `open fun getCurrencyApi(): `[`CurrencyAPI`](../../com.dhirajgupta.currencies.api/-currency-a-p-i/index.md) |
| [getDiskIOExecutor](get-disk-i-o-executor.md) | `open fun getDiskIOExecutor(): `[`Executor`](https://developer.android.com/reference/java/util/concurrent/Executor.html) |
| [getNetworkExecutor](get-network-executor.md) | `open fun getNetworkExecutor(): `[`Executor`](https://developer.android.com/reference/java/util/concurrent/Executor.html) |
| [getRepository](get-repository.md) | `open fun getRepository(): `[`CurrencyRepository`](../../com.dhirajgupta.currencies.repository/-currency-repository/index.md) |
