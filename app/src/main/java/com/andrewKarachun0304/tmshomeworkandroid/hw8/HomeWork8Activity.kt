package com.andrewKarachun0304.tmshomeworkandroid.hw8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.andrewKarachun0304.tmshomeworkandroid.R
import com.andrewKarachun0304.tmshomeworkandroid.hw8.retrofit.RetrofitFactory
import kotlinx.android.synthetic.main.activity_home_work8.*
import kotlinx.coroutines.*

class HomeWork8Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_work8)

        val retrofit = RetrofitFactory().getInstance()

        get_data_btn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val response = retrofit.getCrypto(1, 4, "USD").await()
                if (response.isSuccessful) {
                    val cryptoResponse = response.body()
//                    val crypto = cryptoResponse?.data?.map {
//                        CryptoMapper.map(it)
//                    }
                    withContext(Dispatchers.Main) {
                        data_tv.text = cryptoResponse.toString()
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@HomeWork8Activity, "ERROR", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}