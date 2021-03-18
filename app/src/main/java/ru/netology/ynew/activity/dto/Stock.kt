package ru.netology.ynew.activity.dto

data class Stock(
    val id: Int,
    val name: String,
    val firm: String,
    val image: String,
    val price: String,
    val priceChange: String,
    val favorite: Boolean
)