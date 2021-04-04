package ru.netology.ynew.activity.repository


import android.content.Context
import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ru.netology.ynew.activity.activity.FavoriteActivity
import ru.netology.ynew.activity.adapter.StocksAdapter
import ru.netology.ynew.activity.dto.Stock

class StockRepositoryFileImpl(
    private val context: Context,
) : StocksRepository {
    private val gson = Gson()
    private val type = TypeToken.getParameterized(List::class.java, Stock::class.java).type
    private val filename = "stocks.json"
    private var stocks = listOf(
        Stock(
            id = 1,
            name = "YNDX",
            firm = "Yandex, LLC",
            image = "image",
            price = "5000P",
            priceChange = "+55P (1,15%)",
            favorite = false
        ),
        Stock(
            id = 2,
            name = "SBER",
            firm = "SBER",
            image = "image",
            price = "6000P",
            priceChange = "+55P (1,15%)",
            favorite = false
        ),
        Stock(
            id = 3,
            name = "MAIL",
            firm = "MAIL, LLC",
            image = "image",
            price = "7000P",
            priceChange = "+55P (1,15%)",
            favorite = false
        ),
        Stock(
            id = 4,
            name = "YNDX",
            firm = "Yandex, LLC",
            image = "image",
            price = "8000P",
            priceChange = "+55P (1,15%)",
            favorite = false
        ),
        Stock(
            id = 5,
            name = "YNDX",
            firm = "Yandex, LLC",
            image = "image",
            price = "9000P",
            priceChange = "+55P (1,15%)",
            favorite = false
        ),
        Stock(
            id = 6,
            name = "YNDX",
            firm = "Yandex, LLC",
            image = "image",
            price = "4764.6P",
            priceChange = "+55P (1,15%)",
            favorite = false
        )
    )
        set(value) {
            field = value
            sync()
        }
    private val data = MutableLiveData(stocks)

    init {
        val file = context.filesDir.resolve(filename)
        if (file.exists()) {
            context.openFileInput(filename).bufferedReader().use {
                stocks = gson.fromJson(it, type)
                data.value = stocks
            }
        } else {
            sync()
        }
    }

    override fun getAll(): LiveData<List<Stock>> = data

    override fun likeById(id: Int) {
        stocks = stocks.map {
            if (it.id != id) it else it.copy(favorite = !it.favorite)
        }
        data.value = stocks
    }

    override fun seeFavorite() {
        stocks = stocks.filter { it.favorite }
        data.value = stocks
    }

    private fun sync() {
        context.openFileOutput(filename, Context.MODE_PRIVATE).bufferedWriter().use {
            it.write(gson.toJson(stocks))
        }
    }

}

