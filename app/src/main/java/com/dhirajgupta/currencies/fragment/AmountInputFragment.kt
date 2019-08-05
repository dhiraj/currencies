package com.dhirajgupta.currencies.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController

import com.dhirajgupta.currencies.R
import com.dhirajgupta.currencies.viewmodel.CurrencyViewModel
import kotlinx.android.synthetic.main.fragment_amount_input.*
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 *
 */
class AmountInputFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_amount_input, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val parentActivity = activity
        if (parentActivity == null) {
            Timber.e("Activity went away after view got created, not continuing view setup!")
            return
        }
        val viewModel = ViewModelProviders.of(parentActivity).get(CurrencyViewModel::class.java)
        val currency = viewModel.chosenCurrency.value
        if (currency == null) {
            Timber.e("Recived null currency as chosen, not continuing view setup!!!")
            return
        }
        viewModel.currentScreenTitle.postValue(getString(R.string.choose_amount_template, currency.iso_code))
        textview_amount_input_description.text =
            getString(R.string.enter_amount_helptext_template, currency.name, currency.iso_code)
        edittext_amount.setText(viewModel.amount.value!!.toString())
        edittext_amount.setOnEditorActionListener { textView, i, keyEvent ->
            viewModel.amount.postValue(textView.text.toString().toDouble())
            findNavController().popBackStack()
            return@setOnEditorActionListener false
        }
    }
}
