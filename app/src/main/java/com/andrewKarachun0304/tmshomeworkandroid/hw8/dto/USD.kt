package com.andrewKarachun0304.tmshomeworkandroid.hw8.dto


import com.google.gson.annotations.SerializedName

data class USD(
    @SerializedName("last_updated")
    var lastUpdated: String? = null,
    @SerializedName("market_cap")
    var marketCap: Double? = null,
    @SerializedName("percent_change_1h")
    var percentChange1h: Double? = null,
    @SerializedName("percent_change_24h")
    var percentChange24h: Double? = null,
    @SerializedName("percent_change_7d")
    var percentChange7d: Double? = null,
    @SerializedName("price")
    var price: Double? = null,
    @SerializedName("volume_24h")
    var volume24h: Double? = null
)