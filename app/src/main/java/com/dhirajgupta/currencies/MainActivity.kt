package com.dhirajgupta.currencies

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.dhirajgupta.currencies.viewmodel.CurrencyViewModel
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

/**
 * The Main (and only) [AppCompatActivity] of the app. Hosts the Navigation Host Fragment for the JetPack
 * Navigation architecture component and sets up a Toolbar as standard Appbar / Actionbar that is used throughout
 * the app.
 *
 * The [MainActivity]'s ViewModel is used throughout the app.
 */
class MainActivity : AppCompatActivity() {
    val viewModel by viewModels<CurrencyViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(appbar)
        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        appbar.setupWithNavController(navController, appBarConfiguration)

        /**
         * Since the JetPack Navigation component doesnt yet provide a mechanism that allows a fragment to
         * programmatically set the title of the associated toolbar, we use a View Model [LiveData] wrapped [String]
         * property to set it up.
         *
         */
        viewModel.currentScreenTitle.observe(this, Observer {
            Timber.i("Screen name changed to $it")
            this@MainActivity.title = it
        })
    }
}
