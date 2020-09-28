package com.andrewKarachun0304.tmshomeworkandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

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
            else -> Intent()
        }
        startActivity(myIntent)
    }
}