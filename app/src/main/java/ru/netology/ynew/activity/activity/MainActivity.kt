package ru.netology.ynew.activity.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import android.view.View
import kotlinx.android.synthetic.main.activity_main.view.*
import ru.netology.ynew.R

import ru.netology.ynew.activity.adapter.OnInterfactionListener
import ru.netology.ynew.activity.adapter.StocksAdapter
import ru.netology.ynew.activity.viewmodel.StocksViewModel
import ru.netology.ynew.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: StocksViewModel by viewModels()
        val adapter = StocksAdapter(object : OnInterfactionListener {
            override fun likeById(id: Int) {
                viewModel.likeById(id)
            }
        })

        binding.list.adapter = adapter
        viewModel.data.observe(this, { stocks ->
            adapter.submitList(stocks)
        })

        binding.buttonStocks.setOnClickListener {
            with(binding.buttonStocks) {
                viewModel.seeAll()
//                buttonFavorites.setImageResource(R.drawable.ic_favorites_light)
//                buttonStocks.setImageResource(R.drawable.ic_stocks)
            }
        }
        binding.buttonFavorites.setOnClickListener {
            with(binding.buttonFavorites) {
                viewModel.seeFavorite()
//                buttonFavorites.setImageResource(R.drawable.ic_favorites)
//                buttonStocks.setImageResource(R.drawable.ic_stocks_light)
            }
        }
    }
}



//этот метод используется для получения текстового запроса, который пользователь ввел  в поле запроса.
// Вы будете использовать это для поиска в своей базе данных и возврата результата.
//        val searchView: SearchView = findViewById(R.id.search_view)
//        val query: CharSequence = searchView.getQuery()
