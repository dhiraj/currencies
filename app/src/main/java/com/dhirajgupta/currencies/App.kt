package com.dhirajgupta.currencies

import android.app.Application
import timber.log.Timber

/**
 * Standard Android App subclass that is useful for most Apps. By providing the shared instance of the App object,
 * we are able to access the Application Context anywhere that it is useful.
 */
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this

        if (BuildConfig.DEBUG) { //Debug level logging so that we can see logging output in LogCat console
            Timber.plant(Timber.DebugTree())
        }
        Timber.i("App starting up...")
    }
    companion object {
        lateinit var instance: App
            private set
    }
}