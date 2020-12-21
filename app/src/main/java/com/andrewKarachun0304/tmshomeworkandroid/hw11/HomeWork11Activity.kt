package com.andrewKarachun0304.tmshomeworkandroid.hw11

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andrewKarachun0304.tmshomeworkandroid.R
import kotlinx.android.synthetic.main.activity_home_work11.*

class HomeWork11Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_work11)

        val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)

        sensorManager.registerListener(object : SensorEventListener {
            override fun onSensorChanged(event: SensorEvent?) {
                val lightValue = event?.values?.get(0) ?: 0.0f
                hw11_text_tv.text = lightValue.toString()
                if (lightValue >= 300) {
                    illumination_background.setBackgroundColor(getColor(R.color.green_custom_color))
                } else {
                    illumination_background.setBackgroundColor(getColor(R.color.red_custom_color))
                }
            }

            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
            }

        }, lightSensor, 1)
    }
}