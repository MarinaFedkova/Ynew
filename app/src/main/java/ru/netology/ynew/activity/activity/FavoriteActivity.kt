package ru.netology.ynew.activity.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import ru.netology.ynew.activity.adapter.OnInterfactionListener
import ru.netology.ynew.activity.adapter.StocksAdapter
import ru.netology.ynew.activity.viewmodel.StocksViewModel
import ru.netology.ynew.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: StocksViewModel by viewModels()
        val adapter = StocksAdapter(object : OnInterfactionListener {
            override fun likeById(id: Int) {
                viewModel.likeById(id)
            }
        })


        viewModel.data.observe(this, { stocks ->
            adapter.submitList(stocks)
        })


        binding.buttonStocks.setOnClickListener {
            with(binding.buttonStocks) {
                finish()
            }
        }
    }
}