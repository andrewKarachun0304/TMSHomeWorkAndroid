package com.andrewKarachun0304.tmshomeworkandroid.hw8.dto


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("circulating_supply")
    var circulatingSupply: Double? = null,
    @SerializedName("cmc_rank")
    var cmcRank: Int? = null,
    @SerializedName("date_added")
    var dateAdded: String? = null,
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("last_updated")
    var lastUpdated: String? = null,
    @SerializedName("max_supply")
    var maxSupply: Long? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("num_market_pairs")
    var numMarketPairs: Int? = null,
    @SerializedName("platform")
    var platform: Any? = null,
    @SerializedName("quote")
    var quote: Quote? = null,
    @SerializedName("slug")
    var slug: String? = null,
    @SerializedName("symbol")
    var symbol: String? = null,
    @SerializedName("tags")
    var tags: List<String>? = null,
    @SerializedName("total_supply")
    var totalSupply: Double? = null
)