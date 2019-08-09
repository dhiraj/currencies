[app](../../index.md) / [com.dhirajgupta.currencies.repository](../index.md) / [CurrencyRepository](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`CurrencyRepository(db: `[`CurrencyDatabase`](../../com.dhirajgupta.currencies.db/-currency-database/index.md)`, api: `[`CurrencyAPI`](../../com.dhirajgupta.currencies.api/-currency-a-p-i/index.md)`, networkExecutor: `[`Executor`](https://developer.android.com/reference/java/util/concurrent/Executor.html)`, ioExecutor: `[`Executor`](https://developer.android.com/reference/java/util/concurrent/Executor.html)`)`

A Repository to provide centralized abstraction for access to currency data to the rest of the app

### Parameters

`db` - The instantiated [CurrencyDatabase](../../com.dhirajgupta.currencies.db/-currency-database/index.md) that will be used

`api` - The instantiated [CurrencyAPI](../../com.dhirajgupta.currencies.api/-currency-a-p-i/index.md) that will be used

`networkExecutor` - The instantiated [Executor](https://developer.android.com/reference/java/util/concurrent/Executor.html) that will be used to make *synchronous* network calls

`ioExecutor` - The instantiated [Executor](https://developer.android.com/reference/java/util/concurrent/Executor.html) that will be used for any writing to the database.