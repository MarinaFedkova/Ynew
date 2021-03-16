package ru.netology.ynew.activity.viewmodel

import androidx.lifecycle.ViewModel
import ru.netology.ynew.activity.repository.StockRepositoryInMemoryImpl
import ru.netology.ynew.activity.repository.StocksRepository

class StocksViewModel : ViewModel() {
    private val repository: StocksRepository = StockRepositoryInMemoryImpl()
    val data = repository.getAll()
    fun like() = repository.like()
}