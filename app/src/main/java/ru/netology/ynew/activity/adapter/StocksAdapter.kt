package ru.netology.ynew.activity.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.netology.ynew.R
import ru.netology.ynew.activity.dto.Stock
import ru.netology.ynew.databinding.CardStockBinding

interface OnInterfactionListener {
    fun likeById(id: Int) {}

}

class StocksAdapter(
        private val onInterfactionListener: OnInterfactionListener
) : ListAdapter<Stock, StockViewHolder>(StockDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockViewHolder {
        val binding = CardStockBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StockViewHolder(binding, onInterfactionListener)
    }

    override fun onBindViewHolder(holder: StockViewHolder, position: Int) {
        val stock = getItem(position)
        holder.bind(stock)
    }
}

class StockViewHolder(
        private val binding: CardStockBinding,
        private val onInterfactionListener: OnInterfactionListener
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(stock: Stock) {
        binding.apply {
            name.text = stock.name
            firm.text = stock.firm
            price.text = stock.price
            priceChange.text = stock.priceChange
            favorite.setImageResource(
                    if (stock.favorite) R.drawable.star_full else R.drawable.star_empty
            )
            favorite.setOnClickListener {
                onInterfactionListener.likeById(stock.id)
            }
        }
    }
}


class StockDiffCallback : DiffUtil.ItemCallback<Stock>() {
    override fun areItemsTheSame(oldItem: Stock, newItem: Stock): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Stock, newItem: Stock): Boolean {
        return oldItem == newItem
    }
}