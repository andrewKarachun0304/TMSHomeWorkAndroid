package com.andrewKarachun0304.tmshomeworkandroid.hw13.dto


import com.google.gson.annotations.SerializedName

data class SummaryResponse(
    @SerializedName("Countries")
    var countries: List<CountryResponse>? = null,
    @SerializedName("Date")
    var date: String? = null,
    @SerializedName("Global")
    var global: GlobalResponse? = null,
    @SerializedName("Message")
    var message: String? = null
) {
    data class CountryResponse(
        @SerializedName("Country")
        var country: String? = null,
        @SerializedName("CountryCode")
        var countryCode: String? = null,
        @SerializedName("Date")
        var date: String? = null,
        @SerializedName("NewConfirmed")
        var newConfirmed: Int? = null,
        @SerializedName("NewDeaths")
        var newDeaths: Int? = null,
        @SerializedName("NewRecovered")
        var newRecovered: Int? = null,
        @SerializedName("Premium")
        var premium: PremiumResponse? = null,
        @SerializedName("Slug")
        var slug: String? = null,
        @SerializedName("TotalConfirmed")
        var totalConfirmed: Int? = null,
        @SerializedName("TotalDeaths")
        var totalDeaths: Int? = null,
        @SerializedName("TotalRecovered")
        var totalRecovered: Int? = null
    ) {
        class PremiumResponse(
        )
    }

    data class GlobalResponse(
        @SerializedName("NewConfirmed")
        var newConfirmed: Int? = null,
        @SerializedName("NewDeaths")
        var newDeaths: Int? = null,
        @SerializedName("NewRecovered")
        var newRecovered: Int? = null,
        @SerializedName("TotalConfirmed")
        var totalConfirmed: Int? = null,
        @SerializedName("TotalDeaths")
        var totalDeaths: Int? = null,
        @SerializedName("TotalRecovered")
        var totalRecovered: Int? = null
    )
}