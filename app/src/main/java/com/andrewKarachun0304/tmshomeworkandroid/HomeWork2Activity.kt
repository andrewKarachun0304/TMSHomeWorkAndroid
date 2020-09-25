package com.andrewKarachun0304.tmshomeworkandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class HomeWork2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_work2)
    }

    fun hW2ButtonOnClick(view: View) {
        val myIntent: Intent? = when(view.id){
            R.id.flagsBtn -> Intent(this, FlagsActivity::class.java)
            R.id.animationBtn -> Intent(this, AnimationActivity::class.java)
            else -> Intent()
        }
        startActivity(myIntent)
    }
}