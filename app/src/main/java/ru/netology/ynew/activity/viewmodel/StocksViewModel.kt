package ru.netology.ynew.activity.viewmodel

import androidx.lifecycle.ViewModel
import ru.netology.ynew.activity.repository.StockRepositoryInMemoryImpl
import ru.netology.ynew.activity.repository.StocksRepository

class StocksViewModel : ViewModel() {
    private val repository: StocksRepository = StockRepositoryInMemoryImpl()
    val data = repository.getAll()
    fun likeById(id: Int) = repository.likeById(id)
    fun seeFavorite() = repository.seeFavorite()

}