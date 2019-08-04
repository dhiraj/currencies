package com.dhirajgupta.currencies.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dhirajgupta.currencies.R
import com.dhirajgupta.currencies.model.OCurrency
import kotlinx.android.synthetic.main.cellview_currency.view.*

class CurrencyListAdapter(): RecyclerView.Adapter<CurrencyListAdapter.CurrencyViewHolder>() {
    private var currencies = emptyList<OCurrency>()


    inner class CurrencyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.cellview_currency, parent, false)
        return CurrencyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        val item = currencies[position]
        val cellView = holder.itemView
        cellView.textview_isocode.text = item.iso_code
        cellView.textview_name.text = item.name
        cellView.textview_price.text = item.price.toString()
    }

    override fun getItemCount() = currencies.size

    fun setCurrencies(currencies: List<OCurrency>){
        this.currencies = currencies
        notifyDataSetChanged()
    }
}