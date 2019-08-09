[app](../../index.md) / [com.dhirajgupta.currencies](../index.md) / [MainActivity](./index.md)

# MainActivity

`class MainActivity : AppCompatActivity`

The Main (and only) [AppCompatActivity](#) of the app. Hosts the Navigation Host Fragment for the JetPack
Navigation architecture component and sets up a Toolbar as standard Appbar / Actionbar that is used throughout
the app.

The [MainActivity](./index.md)'s ViewModel is used throughout the app.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MainActivity()`<br>The Main (and only) [AppCompatActivity](#) of the app. Hosts the Navigation Host Fragment for the JetPack Navigation architecture component and sets up a Toolbar as standard Appbar / Actionbar that is used throughout the app. |

### Properties

| Name | Summary |
|---|---|
| [viewModel](view-model.md) | `val viewModel: `[`CurrencyViewModel`](../../com.dhirajgupta.currencies.viewmodel/-currency-view-model/index.md) |

### Functions

| Name | Summary |
|---|---|
| [onCreate](on-create.md) | `fun onCreate(savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
