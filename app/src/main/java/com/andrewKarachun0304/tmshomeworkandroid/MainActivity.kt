package com.andrewKarachun0304.tmshomeworkandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.andrewKarachun0304.tmshomeworkandroid.hw1.HomeWork1Activity
import com.andrewKarachun0304.tmshomeworkandroid.hw2.HomeWork2Activity
import com.andrewKarachun0304.tmshomeworkandroid.hw3.HarvestActivityHW4
import com.andrewKarachun0304.tmshomeworkandroid.hw4.HomeWork4Activity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun homeWorkBtnOnClick(view: View) {
        val myIntent: Intent? = when(view.id){
            R.id.hw1_btn -> Intent(this, HomeWork1Activity::class.java)
            R.id.hw2_btn -> Intent(this, HomeWork2Activity::class.java)
            R.id.hw3_btn -> Intent(this, HarvestActivityHW4::class.java)
            R.id.hw4_btn -> Intent(this, HomeWork4Activity::class.java)
            else -> null
        }
        if (myIntent != null){
            startActivity(myIntent)
        }
    }
}