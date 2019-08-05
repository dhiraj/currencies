[app](../index.md) / [com.dhirajgupta.currencies](./index.md)

## Package com.dhirajgupta.currencies

### Types

| Name | Summary |
|---|---|
| [App](-app/index.md) | `class App : `[`Application`](https://developer.android.com/reference/android/app/Application.html)<br>Standard Android App subclass that is useful for most Apps. By providing the shared instance of the App object, we are able to access the Application Context anywhere that it is useful. |
| [DefaultServiceLocator](-default-service-locator/index.md) | `open class DefaultServiceLocator : `[`ServiceLocator`](-service-locator/index.md)<br>default implementation of ServiceLocator that uses production endpoints. |
| [MainActivity](-main-activity/index.md) | `class MainActivity : AppCompatActivity`<br>The Main (and only) [AppCompatActivity](#) of the app. Hosts the Navigation Host Fragment for the JetPack Navigation architecture component and sets up a Toolbar as standard Appbar / Actionbar that is used throughout the app. |
| [ServiceLocator](-service-locator/index.md) | `interface ServiceLocator`<br>Super simplified service locator implementation to allow us to replace default implementations for testing. |
