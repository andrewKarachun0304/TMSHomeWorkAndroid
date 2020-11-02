package com.andrewKarachun0304.tmshomeworkandroid.hw8.dto


import com.google.gson.annotations.SerializedName

data class CryptoResponse(
    @SerializedName("data")
    var `data`: List<Data>? = null,
    @SerializedName("status")
    var status: Status? = null
)