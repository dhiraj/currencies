[app](../../index.md) / [com.dhirajgupta.currencies.model](../index.md) / [KVPair](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`KVPair(k: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, v: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)`

The [KVPair](index.md) model is used as a standard way for the app to persist any key value pair. Using a KVPair like this
allows us to have the LiveData machinery supported through Room available to power the UI directly instead of
resorting to clumsy SharedPreferences mechanisms.

