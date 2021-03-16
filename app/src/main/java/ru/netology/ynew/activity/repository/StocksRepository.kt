package ru.netology.ynew.activity.repository

import androidx.lifecycle.LiveData
import ru.netology.ynew.activity.dto.Stock

interface StocksRepository {
    fun getAll(): LiveData<List<Stock>>
    fun like()
}