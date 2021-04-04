package ru.netology.ynew.activity.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import ru.netology.ynew.activity.repository.StockRepositoryFileImpl
import ru.netology.ynew.activity.repository.StocksRepository

class StocksViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: StocksRepository = StockRepositoryFileImpl(application)
    val data = repository.getAll()
    fun likeById(id: Int) = repository.likeById(id)
    fun seeFavorite() = repository.seeFavorite()

}