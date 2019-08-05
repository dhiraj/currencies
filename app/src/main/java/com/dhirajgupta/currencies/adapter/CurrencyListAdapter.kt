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


class OCurrencyDiffCallback : DiffUtil.ItemCallback<OCurrency>() {
    override fun areItemsTheSame(oldItem: OCurrency, newItem: OCurrency): Boolean =
        oldItem.iso_code == newItem.iso_code

    override fun areContentsTheSame(oldItem: OCurrency, newItem: OCurrency): Boolean =
        oldItem.iso_code == newItem.iso_code && oldItem.price == newItem.price && oldItem.name == newItem.name
}

class CurrencyListAdapter() : ListAdapter<OCurrency, CurrencyListAdapter.CurrencyViewHolder>(OCurrencyDiffCallback()) {
    var chosenCurrency:OCurrency? = null
    var amount: Double = 1.toDouble()
    var clicked: ((OCurrency) -> Unit)? = null
    inner class CurrencyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener {
                val listener = clicked
                if (listener != null){
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
        if (setCurrency != null){
            val calculatedQuote = (amount / setCurrency.price) * item.price
            cellView.textview_price.text = cellView.context.getString(R.string.price_template).format(calculatedQuote)
        }
        else{
            cellView.textview_price.text = cellView.context.getString(R.string.price_template).format(item.price)
        }
    }


}
