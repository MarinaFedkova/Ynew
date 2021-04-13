package ru.netology.ynew.activity.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import ru.netology.ynew.activity.repository.StockRepositoryInMemoryImpl
import ru.netology.ynew.activity.repository.StocksRepository

class StocksViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: StocksRepository = StockRepositoryInMemoryImpl()
    val data = repository.getAll()
    fun likeById(id: Int) = repository.likeById(id)
    fun seeFavorite() = repository.seeFavorite()
}