package com.andrewKarachun0304.tmshomeworkandroid.hw8.retrofit

import com.andrewKarachun0304.tmshomeworkandroid.hw8.network.CryptoApi
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

private const val API_KEY_VALUE = "5631e17c-e12e-459f-8ffd-3bbdbd99c05a"
private const val API_KEY_NAME = "X-CMC_PRO_API_KEY"
private const val BASE_URL = "https://pro-api.coinmarketcap.com/v1/"

class RetrofitFactory {
    private val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .addInterceptor(object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val request = chain
                    .request()
                    .newBuilder()
                    .addHeader(API_KEY_NAME, API_KEY_VALUE)
                    .build()
                return chain.proceed(request)
            }
        })

    fun getInstance(): CryptoApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .client(client.build())
        .build()
        .create()
}