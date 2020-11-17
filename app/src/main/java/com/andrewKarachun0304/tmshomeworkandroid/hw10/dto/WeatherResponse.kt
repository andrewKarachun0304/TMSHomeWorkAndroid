package com.andrewKarachun0304.tmshomeworkandroid.hw10.dto


import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("base")
    var base: String? = null,
    @SerializedName("clouds")
    var clouds: Clouds? = null,
    @SerializedName("cod")
    var cod: Double? = null,
    @SerializedName("coord")
    var coord: Coord? = null,
    @SerializedName("dt")
    var dt: Double? = null,
    @SerializedName("id")
    var id: Double? = null,
    @SerializedName("main")
    var main: Main? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("sys")
    var sys: Sys? = null,
    @SerializedName("timezone")
    var timezone: Double? = null,
    @SerializedName("visibility")
    var visibility: Double? = null,
    @SerializedName("weather")
    var weather: List<Weather?>? = null,
    @SerializedName("wind")
    var wind: Wind? = null
) {
    data class Clouds(
        @SerializedName("all")
        var all: Double? = null
    )

    data class Coord(
        @SerializedName("lat")
        var lat: Double? = null,
        @SerializedName("lon")
        var lon: Double? = null
    )

    data class Main(
        @SerializedName("feels_like")
        var feelsLike: Double? = null,
        @SerializedName("humidity")
        var humidity: Double? = null,
        @SerializedName("pressure")
        var pressure: Double? = null,
        @SerializedName("temp")
        var temp: Double? = null,
        @SerializedName("temp_max")
        var tempMax: Double? = null,
        @SerializedName("temp_min")
        var tempMin: Double? = null
    )

    data class Sys(
        @SerializedName("country")
        var country: String? = null,
        @SerializedName("id")
        var id: Double? = null,
        @SerializedName("sunrise")
        var sunrise: Double? = null,
        @SerializedName("sunset")
        var sunset: Double? = null,
        @SerializedName("type")
        var type: Double? = null
    )

    data class Weather(
        @SerializedName("description")
        var description: String? = null,
        @SerializedName("icon")
        var icon: String? = null,
        @SerializedName("id")
        var id: Double? = null,
        @SerializedName("main")
        var main: String? = null
    )

    data class Wind(
        @SerializedName("deg")
        var deg: Double? = null,
        @SerializedName("speed")
        var speed: Double? = null
    )
}