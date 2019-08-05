package com.dhirajgupta.currencies.fragment


import android.os.Bundle
import android.os.Handler
import android.view.*
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
    var autoFetchedCurrencyList = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_currency_list, container, false)
    }

    val networkStateObserver = Observer { state: NetworkState ->
        Timber.i("Network status changed: $state")
        swipe_container.isRefreshing = state.status == Status.RUNNING
    }

    fun currencyListAdapter() = recyclerview_currency.adapter as CurrencyListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val parentActivity = activity
        if (parentActivity != null) {
            val viewModel = ViewModelProviders.of(parentActivity).get(CurrencyViewModel::class.java)
            recyclerview_currency.apply {
                adapter = CurrencyListAdapter()
                layoutManager = LinearLayoutManager(view.context)
            }
            viewModel.currencyList.observe(this@CurrencyListFragment, Observer { currencies ->
                Timber.i("Currencies updated: ${currencies.size}")
                currencyListAdapter().submitList(currencies)
                if (currencies.size == 0 && !autoFetchedCurrencyList) {
                    Timber.i("Currencies list is empty, refreshing from API...")
                    autoFetchedCurrencyList = true
                    viewModel.refreshCurrencies().observe(this@CurrencyListFragment, networkStateObserver)
                }
            })
            swipe_container.setOnRefreshListener {
                viewModel.refreshCurrencies().observe(this@CurrencyListFragment, networkStateObserver)
            }
            viewModel.chosenCurrency.observe(this@CurrencyListFragment, Observer {
                Timber.i("Chosen currency changed: $it")
                if (it == null) {
                    viewModel.chooseCurrency(DEFAULT_CURRENCY_ISO)
                } else {
                    viewModel.currentScreenTitle.value = getString(R.string.currency_list_title_template,viewModel.amount.value,it.iso_code)
                    currencyListAdapter().apply {
                        chosenCurrency = it
                        amount = viewModel.amount.value!! //Can never be null
                        notifyDataSetChanged()
                    }
                }
            })
            currencyListAdapter().clicked = {newcurrency ->
                val oldcurrency = viewModel.chosenCurrency.value!!
                val oldamount = viewModel.amount.value!!
                viewModel.amount.value = (oldamount / oldcurrency.price) * newcurrency.price
                viewModel.chooseCurrency(newcurrency.iso_code)
//                Handler().postDelayed({findNavController().navigate(R.id.action_currencyListFragment_to_amountInputFragment)},30)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_currency_list,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menuitem_edit -> findNavController().navigate(R.id.action_currencyListFragment_to_amountInputFragment)
        }
        return super.onOptionsItemSelected(item)
    }
}
