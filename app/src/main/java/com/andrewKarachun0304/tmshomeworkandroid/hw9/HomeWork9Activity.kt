package com.andrewKarachun0304.tmshomeworkandroid.hw9

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.annotation.RequiresApi
import com.andrewKarachun0304.tmshomeworkandroid.R
import kotlinx.android.synthetic.main.activity_home_work9.*
import java.util.*

class HomeWork9Activity : AppCompatActivity() {
    private var timer: CountDownTimer? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_work9)

        val serviceIntent = Intent(this@HomeWork9Activity, TimerService::class.java)

        start_btn1.setOnClickListener {
            val second = time_picker.minute * 60
            timer = object : CountDownTimer(second * 1000L, 1000) {
                override fun onTick(p0: Long) {
                    val sec = p0 / 1000 % 60
                    val min = (p0 / 1000 % 3600) / 60
                    val time = String.format(Locale.getDefault(), "$min : $sec")
                    time_tv.text = time
                }

                override fun onFinish() {
                    serviceIntent.putExtra("time", second)
                    startService(serviceIntent)
                }
            }
            (timer as CountDownTimer).start()
        }

        stop_btn1.setOnClickListener {
            (timer as CountDownTimer).cancel()
            time_tv.text = ""
        }
    }
}