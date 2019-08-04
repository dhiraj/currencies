package com.dhirajgupta.currencies.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.dhirajgupta.currencies.R

/**
 * Shows the detail about a particular chosen currency and allows the user to set an amount
 *
 */
class CurrencyDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_currency_detail, container, false)
    }


}
