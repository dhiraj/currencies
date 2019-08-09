package com.dhirajgupta.currencies.fragment


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import androidx.core.content.getSystemService
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController

import com.dhirajgupta.currencies.R
import com.dhirajgupta.currencies.viewmodel.CurrencyViewModel
import kotlinx.android.synthetic.main.fragment_amount_input.*
import timber.log.Timber

/**
 * A fragment that handles the user's input to set the chosen amount that will be converted.
 *
 */
class AmountInputFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_amount_input, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val parentActivity = activity
        if (parentActivity == null) {
            Timber.e("Activity went away after view got created, not continuing view setup!")
            return
        }
        /**
         * Use the Activity's [CurrencyViewModel] as the backing ViewModel.
         */
        val viewModel = ViewModelProviders.of(parentActivity).get(CurrencyViewModel::class.java)
        val currency = viewModel.chosenCurrency.value
        if (currency == null) {
            Timber.e("Received null currency as chosen, not continuing view setup!!!")
            return
        }
        //Set the screen title as a visual cue to the user for the action to be done
        viewModel.currentScreenTitle.postValue(getString(R.string.choose_amount_template, currency.iso_code))

        //More visual cue and help text
        textview_amount_input_description.text =
            getString(R.string.enter_amount_helptext_template, currency.name, currency.iso_code)
        edittext_amount.setText(getString(R.string.price_template, viewModel.amount.value!!))
        edittext_amount.setOnEditorActionListener { textView, i, keyEvent ->
            /**
             * When the user presses the done button on the soft keyboard, we set it on the shared [CurrencyViewModel]
             * and navigate back to show the updated values.
             * Note: The inputmode on the [EditText] is set to Numeric to ensure that only numeric values can be entered.
             */
            viewModel.amount.postValue(textView.text.toString().toDouble())
            findNavController().popBackStack()
            return@setOnEditorActionListener false
        }

        /**
         * Automatically raise the keyboard to save the user a tap.
         */
        val input_service = parentActivity.getSystemService(Context.INPUT_METHOD_SERVICE)
        if (input_service != null) {
            (input_service as InputMethodManager).toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 0)
        }
    }
}
