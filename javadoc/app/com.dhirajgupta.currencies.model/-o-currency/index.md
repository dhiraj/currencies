[app](../../index.md) / [com.dhirajgupta.currencies.model](../index.md) / [OCurrency](./index.md)

# OCurrency

`data class OCurrency`

A model / room data class that will store data about a particular currency.
The Name OCurrency is chosen to prevent mistaken conflicts with Java's Currency class.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `OCurrency(iso_code: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, price: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = 0.toDouble())`<br>A model / room data class that will store data about a particular currency. The Name OCurrency is chosen to prevent mistaken conflicts with Java's Currency class. |

### Properties

| Name | Summary |
|---|---|
| [iso_code](iso_code.md) | `val iso_code: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The currency's 3 letter ISO code |
| [name](name.md) | `val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The full name of the currency |
| [price](price.md) | `var price: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)<br>The current / last known price of the currency against 1 US Dollar |
