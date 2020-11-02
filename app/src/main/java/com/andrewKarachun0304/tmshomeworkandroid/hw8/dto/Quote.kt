package com.andrewKarachun0304.tmshomeworkandroid.hw8.dto


import com.google.gson.annotations.SerializedName

data class Quote(
    @SerializedName("USD")
    var uSD: USD? = null
)