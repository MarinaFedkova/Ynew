package ru.netology.ynew.activity.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
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

        binding.buttonFavorites.setOnClickListener {
            val intent = Intent(this, FavoriteActivity::class.java)
            startActivity(intent)
        }
    }
}


//этот метод используется для получения текстового запроса, который пользователь ввел  в поле запроса.
// Вы будете использовать это для поиска в своей базе данных и возврата результата.
//        val searchView: SearchView = findViewById(R.id.search_view)
//        val query: CharSequence = searchView.getQuery()
