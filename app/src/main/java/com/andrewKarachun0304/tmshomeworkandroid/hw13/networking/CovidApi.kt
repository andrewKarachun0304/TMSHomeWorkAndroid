package com.andrewKarachun0304.tmshomeworkandroid.hw13.networking

import com.andrewKarachun0304.tmshomeworkandroid.hw13.dto.SummaryResponse
import io.reactivex.Single
import retrofit2.http.GET

interface CovidApi {
    @GET("summary")
    fun getSummaryDataAsync(): Single<SummaryResponse>
}