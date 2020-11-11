package com.andrewKarachun0304.tmshomeworkandroid.hw8.network

import com.andrewKarachun0304.tmshomeworkandroid.hw8.dto.CryptoResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoApi {
    @GET("cryptocurrency/listings/latest")
    fun getCryptoAsync(
        @Query("start")
        start: Int,
        @Query("limit")
        limit: Int,
        @Query("convert")
        convert: String
    ): Deferred<Response<CryptoResponse>>
}