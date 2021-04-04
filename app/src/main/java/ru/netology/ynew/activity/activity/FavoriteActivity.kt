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

        val stocks = intent.getParcelableArrayExtra("favoritesStocks")

        binding.buttonStocks.setOnClickListener {
            with(binding.buttonStocks) {
                finish()
            }
        }
    }
}