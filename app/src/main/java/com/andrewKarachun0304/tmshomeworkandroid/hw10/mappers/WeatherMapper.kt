package com.andrewKarachun0304.tmshomeworkandroid.hw10.mappers

import com.andrewKarachun0304.tmshomeworkandroid.hw10.dto.WeatherResponse
import com.andrewKarachun0304.tmshomeworkandroid.hw10.entity.CurrentWeather

object WeatherMapper {
    fun parse(from: WeatherResponse?) = CurrentWeather(
        description = from?.weather?.get(0)?.description.orEmpty(),
        iconId = from?.weather?.get(0)?.icon.orEmpty(),
        temp = from?.main?.temp ?: 0.0,
        cityName = from?.name.orEmpty()
    )
}