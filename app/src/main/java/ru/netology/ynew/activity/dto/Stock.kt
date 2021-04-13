package ru.netology.ynew.activity.dto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Stock(
    val id: Int,
    val name: String,
    val firm: String,
    val image: String,
    val price: String,
    val priceChange: String,
    val favorite: Boolean
): Parcelable