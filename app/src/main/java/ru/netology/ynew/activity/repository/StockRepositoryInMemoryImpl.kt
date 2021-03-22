package ru.netology.ynew.activity.repository


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.ynew.activity.dto.Stock

class StockRepositoryInMemoryImpl : StocksRepository {
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
                    name = "YNDX",
                    firm = "Yandex, LLC",
                    image = "image",
                    price = "6000P",
                    priceChange = "+55P (1,15%)",
                    favorite = false
            ),
            Stock(
                    id = 3,
                    name = "YNDX",
                    firm = "Yandex, LLC",
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

    private val data = MutableLiveData(stocks)

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

    override fun seeAll() {
        getAll()
        data.value = stocks
    }

}

