package com.dhirajgupta.currencies.fragment


import android.os.Bundle
import android.os.Handler
import android.view.*
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.dhirajgupta.currencies.R
import com.dhirajgupta.currencies.adapter.CurrencyListAdapter
import com.dhirajgupta.currencies.model.DEFAULT_CURRENCY_ISO
import com.dhirajgupta.currencies.model.NetworkState
import com.dhirajgupta.currencies.model.Status
import com.dhirajgupta.currencies.viewmodel.CurrencyViewModel
import kotlinx.android.synthetic.main.fragment_currency_list.*
import timber.log.Timber

/**
 * Shows the list of all the currencies currently available along with the exchange rate for the chosen base currency
 *
 */
class CurrencyListFragment : Fragment() {
    /**
     * a flag to track if we have auto-fetched the currencies list from the [CurrencyAPI] in the initial state. Tracking
     * this is required to prevent entering an indefinite loop of re-fetching in the case when no Internet is present
     * in the initial state.
     */
    var autoFetchedCurrencyList = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true) //Will manipulate the toolbar menu
        return inflater.inflate(R.layout.fragment_currency_list, container, false)
    }

    /**
     * Observer to update the swipe container refreshing status based on the [NetworkState]
     */
    val networkStateObserver = Observer { state: NetworkState ->
        Timber.i("Network status changed: $state")
        swipe_container.isRefreshing = state.status == Status.RUNNING
    }

    /**
     * Convenience function to return the [ListAdapter] typecasted the way we need it to be.
     */
    fun currencyListAdapter() = recyclerview_currency.adapter as CurrencyListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val parentActivity = activity
        if (parentActivity != null) { //Null-check to ensure activity is valid

            /**
             * Use the Activity's [CurrencyViewModel] as the backing ViewModel.
             */
            val viewModel = ViewModelProviders.of(parentActivity).get(CurrencyViewModel::class.java)

            recyclerview_currency.apply {
                adapter = CurrencyListAdapter()
                layoutManager = LinearLayoutManager(view.context)
            }

            /**
             * Observe the OCurrency List in the model and submit it to the adapter whenever it changes.
             */
            viewModel.currencyList.observe(this@CurrencyListFragment, Observer { currencies ->
                Timber.i("Currencies updated: ${currencies.size}")
                currencyListAdapter().submitList(currencies)

                /**
                 * Specific initial-case check to only attempt to automatically load the Currency API once, after the
                 * [CurrencyListFragment] is loaded.
                 */
                if (currencies.size == 0 && !autoFetchedCurrencyList) {
                    Timber.i("Currencies list is empty, refreshing from API...")
                    autoFetchedCurrencyList = true
                    viewModel.refreshCurrencies().observe(this@CurrencyListFragment, networkStateObserver)
                }
            })
            swipe_container.setOnRefreshListener {
                //Allow the User to refresh from API whenever they want
                //ToDo: Maintain the timestamp when the API last refreshed, and display it to the user in some way
                viewModel.refreshCurrencies().observe(this@CurrencyListFragment, networkStateObserver)
            }

            /**
             * Observe changes to the Chosen Currency and update the [CurrencyListAdapter] with the updated currency
             * and amount whenever it happens. In both these cases, we *know* that the entire recyclerview must be
             * invalidated so we call notifyDataSetChanged() instead of submitting the list for diffing.
             */
            viewModel.chosenCurrency.observe(this@CurrencyListFragment, Observer {
                Timber.i("Chosen currency changed: $it")
                if (it == null) {
                    viewModel.chooseCurrency(DEFAULT_CURRENCY_ISO)
                } else {
                    //Update the screen title to show the new currency and amount
                    viewModel.currentScreenTitle.value =
                        getString(R.string.currency_list_title_template, viewModel.amount.value, it.iso_code)
                    currencyListAdapter().apply {
                        chosenCurrency = it
                        amount = viewModel.amount.value!! //Can never be null, we have always set a default value
                        notifyDataSetChanged()
                    }
                }
            })

            /**
             * When the user chooses a currency, we assume that they don't want to see the actual numeric amount
             * reflected directly in the new currency they have chosen. Instead it is more natural/useful to tweak the
             * converted amount because the value of the money remains the same, in this way.
             * We therefore calculate a new amount based on the newly chosen currency to retain the same monetary value
             * prior to switching the destination currency.
             */
            currencyListAdapter().clicked = { newcurrency ->
                val oldcurrency = viewModel.chosenCurrency.value!!
                val oldamount = viewModel.amount.value!!
                viewModel.amount.value = (oldamount / oldcurrency.price) * newcurrency.price
                viewModel.chooseCurrency(newcurrency.iso_code)
                /**
                 * After choosing a new currency, we automatically show the amount input screen so that the user can
                 * tweak the amount to see updated values*
                 */

                // ToDo: Have a way to allow the user to favorite currencies so that these can be seen together on top of
                // the currencies list. Alternatively, only add and display the currencies that a user is actually
                // interested in, instead of showing all of them because scrolling to compare currencies that are
                // far apart is inconvenient.
                Handler().postDelayed(
                    { findNavController().navigate(R.id.action_currencyListFragment_to_amountInputFragment) },
                    30
                )
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_currency_list, menu)
    }

    /**
     * Since we remove the chosen currency from the list, we need to have an Edit button so that the user can edit
     * the amount more than once after selecting it.
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuitem_edit -> findNavController().navigate(R.id.action_currencyListFragment_to_amountInputFragment)
        }
        return super.onOptionsItemSelected(item)
    }
}
