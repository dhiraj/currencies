[app](../../index.md) / [com.dhirajgupta.currencies.db](../index.md) / [CurrencyDatabase](./index.md)

# CurrencyDatabase

`abstract class CurrencyDatabase : RoomDatabase`

The Room Database class that will manage the backing SQLite persistence database to the Currencies app.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CurrencyDatabase()`<br>The Room Database class that will manage the backing SQLite persistence database to the Currencies app. |

### Functions

| Name | Summary |
|---|---|
| [currencyDao](currency-dao.md) | `abstract fun currencyDao(): `[`CurrencyDao`](../-currency-dao/index.md)<br>The main OCurrency DAO that will be used throughout the app |

### Companion Object Functions

| Name | Summary |
|---|---|
| [create](create.md) | `fun create(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, useInMemory: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`CurrencyDatabase`](./index.md) |
