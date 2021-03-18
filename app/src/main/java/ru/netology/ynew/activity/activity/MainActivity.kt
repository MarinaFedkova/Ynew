package ru.netology.ynew.activity.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import ru.netology.ynew.R
import ru.netology.ynew.activity.adapter.StocksAdapter
import ru.netology.ynew.activity.viewmodel.StocksViewModel
import ru.netology.ynew.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: StocksViewModel by viewModels()
        val adapter = StocksAdapter {
            viewModel.likeById(it.id)
        }
        binding.list.adapter = adapter
        viewModel.data.observe(this, { stocks ->
            adapter.submitList(stocks)
        })

    }
}



//этот метод используется для получения текстового запроса, который пользователь ввел  в поле запроса.
// Вы будете использовать это для поиска в своей базе данных и возврата результата.
//        val searchView: SearchView = findViewById(R.id.search_view)
//        val query: CharSequence = searchView.getQuery()

//        button_stocks.setOnClickListener {
//            seeAllStocks()
//
//        }
//
//        button_favorites.setOnClickListener {
//            seeFavorites()
//        }

//        fun seeFavorites() {
//            var favoriteList = stocks.filter { it.isFavorite == true }
//
//            button_favorites.setTextSize(28)
//            button_favorites.setTextColor("black")
//            button_stocks.setTextSize(24)
//            button_stocks.setTextColor("lightblack") //
//        }

//кнопка меняет шрифт, отображается весь список акций.
// кнопка Favorites меняет шрифт? или лучше менять картинку?
//        fun seeAllStocks() {
//
//        }



