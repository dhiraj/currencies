package com.dhirajgupta.currencies.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.dhirajgupta.currencies.R
import com.dhirajgupta.currencies.adapter.CurrencyListAdapter
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
    val viewModel by viewModels<CurrencyViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_currency_list, container, false)
    }

    val networkStateObserver = Observer { state: NetworkState ->
        Timber.i("Network status changed: $state")
        swipe_container.isRefreshing = state.status == Status.RUNNING
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerview_currency.apply {
            adapter = CurrencyListAdapter()
            layoutManager = LinearLayoutManager(view.context)
        }
        viewModel.allCurrencies.observe(this@CurrencyListFragment, Observer { currencies ->
            Timber.i("Currencies updated: ${currencies.size}")
            (recyclerview_currency.adapter as CurrencyListAdapter).setCurrencies(currencies)
        })
        viewModel.refreshCurrencies().observe(this@CurrencyListFragment, networkStateObserver)
        swipe_container.setOnRefreshListener {
            viewModel.refreshCurrencies().observe(this@CurrencyListFragment, networkStateObserver)
        }
    }
}
