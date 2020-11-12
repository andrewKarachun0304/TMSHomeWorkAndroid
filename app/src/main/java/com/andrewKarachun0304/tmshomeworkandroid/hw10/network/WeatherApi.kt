package com.andrewKarachun0304.tmshomeworkandroid.hw10.network

import com.andrewKarachun0304.tmshomeworkandroid.hw10.dto.WeatherResponse
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi{
    @GET("data/2.5/weather")
    fun getWeatherInfoAsync(
        @Query("q") q: String,
        @Query("appid") api: String = "bd1962a1ae7f70ced1334772badc1686",
        @Query("lang") lang: String = "ru",
        @Query("units") units: String = "metric"
    ): Deferred<Response<WeatherResponse>>
}