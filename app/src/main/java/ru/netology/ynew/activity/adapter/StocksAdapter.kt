package ru.netology.ynew.activity.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.netology.ynew.R
import ru.netology.ynew.activity.dto.Stock
import ru.netology.ynew.databinding.CardStockBinding

typealias OnLikeListener = (stock: Stock) -> Unit

class StocksAdapter(
    private val onLikeListener: OnLikeListener
) : ListAdapter<Stock, StockViewHolder>(StockDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockViewHolder {
        val binding = CardStockBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StockViewHolder(binding, onLikeListener)
    }

    override fun onBindViewHolder(holder: StockViewHolder, position: Int) {
        val stock = getItem(position)
        holder.bind(stock)
    }
}

class StockViewHolder(
    private val binding: CardStockBinding,
    private val onLikeListener: OnLikeListener
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(stock: Stock) {
        binding.apply {
            favorite.setImageResource(
                if (stock.favorite) R.drawable.star_full else R.drawable.star_empty
            )
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