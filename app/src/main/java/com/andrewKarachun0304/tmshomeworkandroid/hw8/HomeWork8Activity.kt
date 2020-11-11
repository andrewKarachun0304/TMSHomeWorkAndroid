package com.andrewKarachun0304.tmshomeworkandroid.hw8

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.andrewKarachun0304.tmshomeworkandroid.R
import com.andrewKarachun0304.tmshomeworkandroid.hw7.utils.launchIO
import com.andrewKarachun0304.tmshomeworkandroid.hw7.utils.launchUI
import com.andrewKarachun0304.tmshomeworkandroid.hw8.adapter.CryptoAdapter
import com.andrewKarachun0304.tmshomeworkandroid.hw8.mappers.CryptoMapper
import com.andrewKarachun0304.tmshomeworkandroid.hw8.network.CryptoApi
import com.andrewKarachun0304.tmshomeworkandroid.hw8.retrofit.RetrofitFactory
import kotlinx.android.synthetic.main.activity_home_work8.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeWork8Activity : AppCompatActivity() {
    private val retrofit by lazy {
        RetrofitFactory().getInstance()
    }
    private val cryptoAdapter by lazy { CryptoAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_work8)

        swipe_refresh_crypto_layout.setOnRefreshListener {
            getData()
        }

        initLayout()
    }

    private fun initLayout() {
        refreshingLayout(true)
        swipe_refresh_crypto_layout.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE)
        crypto_recycler_view.apply {
            adapter = cryptoAdapter
            layoutManager = LinearLayoutManager(this@HomeWork8Activity)
        }
        getData()
    }

    private fun getData() {
        launchIO {
            val response = retrofit.getCryptoAsync(1, 10, "USD").await()

            if (response.isSuccessful) {
                val cryptoResponse = response.body()
                val crypto = cryptoResponse?.dataList?.map {
                    CryptoMapper.map(it)
                }
                launchUI {
                    cryptoAdapter.updateList(crypto)
                    refreshingLayout(false)
                }
            } else {
                launchUI {
                    Toast.makeText(this@HomeWork8Activity, "ERROR", Toast.LENGTH_SHORT)
                        .show()
                    refreshingLayout(false)
                }
            }
        }
    }

    private fun refreshingLayout(status: Boolean) {
        swipe_refresh_crypto_layout.isRefreshing = status
    }
}