package com.andrewKarachun0304.tmshomeworkandroid.hw10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andrewKarachun0304.tmshomeworkandroid.R
import com.andrewKarachun0304.tmshomeworkandroid.hw10.mappers.WeatherMapper
import com.andrewKarachun0304.tmshomeworkandroid.hw10.retrofit.RetrofitWeatherFactory
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_home_work10.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeWork10Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_work10)
    }
}