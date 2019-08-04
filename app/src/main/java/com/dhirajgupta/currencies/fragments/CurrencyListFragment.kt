package com.dhirajgupta.currencies.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.dhirajgupta.currencies.R
import com.dhirajgupta.currencies.adapters.CurrencyListAdapter
import com.dhirajgupta.currencies.viewmodels.CurrencyViewModel
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerview_currency.apply {
            adapter = CurrencyListAdapter()
            layoutManager = LinearLayoutManager(view.context)
        }
        viewModel.allCurrencies.observe(this@CurrencyListFragment, Observer { currencies ->
            Timber.i("Currencies updated: ${currencies.size}")
        })
    }
}
