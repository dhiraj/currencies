package com.dhirajgupta.currencies.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dhirajgupta.currencies.R
import com.dhirajgupta.currencies.model.Currency
import kotlinx.android.synthetic.main.cellview_currency.view.*

class CurrencyListAdapter(): RecyclerView.Adapter<CurrencyListAdapter.CurrencyViewHolder>() {
    private var currencies = emptyList<Currency>()


    inner class CurrencyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.cellview_currency, parent, false)
        return CurrencyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        val item = currencies[position]
        holder.itemView.textView.text = item.iso_code
    }

    override fun getItemCount() = currencies.size

    fun setCurrencies(currencies: List<Currency>){
        this.currencies = currencies
        notifyDataSetChanged()
    }
}