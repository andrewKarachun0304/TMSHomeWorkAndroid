package com.andrewKarachun0304.tmshomeworkandroid.hw8.dto


import com.google.gson.annotations.SerializedName

data class Status(
    @SerializedName("credit_count")
    var creditCount: Int? = null,
    @SerializedName("elapsed")
    var elapsed: Int? = null,
    @SerializedName("error_code")
    var errorCode: Int? = null,
    @SerializedName("error_message")
    var errorMessage: Any? = null,
    @SerializedName("notice")
    var notice: Any? = null,
    @SerializedName("timestamp")
    var timestamp: String? = null,
    @SerializedName("total_count")
    var totalCount: Int? = null
)