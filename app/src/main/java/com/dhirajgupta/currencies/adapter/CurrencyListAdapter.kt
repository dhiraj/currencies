package com.dhirajgupta.currencies.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dhirajgupta.currencies.R
import com.dhirajgupta.currencies.model.OCurrency
import kotlinx.android.synthetic.main.cellview_currency.view.*


/**
 * Standard [DiffUtil.Callback] subclass to allow faster updates when the user's chosen currency or amount changes, or
 * when the [CurrencyApi] returns updated results.
 */
class OCurrencyDiffCallback : DiffUtil.ItemCallback<OCurrency>() {
    /**
     * [OCurrency] iso_code is the object's primary key in Room and is a prime candidate to determine if two items
     * are the same.
     */
    override fun areItemsTheSame(oldItem: OCurrency, newItem: OCurrency): Boolean =
        oldItem.iso_code == newItem.iso_code

    /**
     * All the properties of the [OCurrency] object are compared to ensure that they are indeed the same object
     * and don't need to be redrawn.
     */
    override fun areContentsTheSame(oldItem: OCurrency, newItem: OCurrency): Boolean =
        oldItem.iso_code == newItem.iso_code && oldItem.price == newItem.price && oldItem.name == newItem.name
}

/**
 * [ListAdapter] subclass that allows us to adapt our [OCurrency] model to be presented to the user in a [RecyclerView]
 * Fairly, standard and straightforward implementation that calculates the conversion quote given the chosen currency
 * and the amount to be converted.
 *
 * @property [chosenCurrency] the adapter needs to be notified whenever the user's chosen currency is changed.
 * @property [amount] the adapter needs to be notified whenever the user's chosen amount is changed.
 * @property [clicked] the adapter will pass on clicks detected to its intended consumer, [CurrencyListFragment]
 * through this function, and pass the user-tapped [OCurrency] model along in the function invocation.
 */
class CurrencyListAdapter() : ListAdapter<OCurrency, CurrencyListAdapter.CurrencyViewHolder>(OCurrencyDiffCallback()) {
    var chosenCurrency: OCurrency? = null
    var amount: Double = 1.toDouble()
    var clicked: ((OCurrency) -> Unit)? = null

    inner class CurrencyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            /**
             * Set up an OnClickListener to forward the click to the [listener] function after performing a null check
             * on it
             */
            itemView.setOnClickListener {
                val listener = clicked
                if (listener != null) {
                    listener(getItem(layoutPosition))
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.cellview_currency, parent, false)
        return CurrencyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        val item = getItem(position)
        val cellView = holder.itemView
        cellView.textview_isocode.text = item.iso_code
        cellView.textview_name.text = item.name
        val setCurrency = chosenCurrency
        /**
         * There can be a case where the chosenCurrency has not been set, so we perform a null check on it and set up
         * a temporary contingency display from the item's price directly.
         */
        if (setCurrency != null) {
            val calculatedQuote = (amount / setCurrency.price) * item.price
            cellView.textview_price.text = cellView.context.getString(R.string.price_template).format(calculatedQuote)
        } else {
            cellView.textview_price.text = cellView.context.getString(R.string.price_template).format(item.price)
        }
    }


}
