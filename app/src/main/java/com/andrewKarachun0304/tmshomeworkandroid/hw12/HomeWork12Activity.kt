package com.andrewKarachun0304.tmshomeworkandroid.hw12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.andrewKarachun0304.tmshomeworkandroid.R

class HomeWork12Activity : AppCompatActivity() {
    private lateinit var numberEt: EditText
    private lateinit var resultTv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_work12)

        numberEt = findViewById(R.id.fibonacci_number_et)
        resultTv = findViewById(R.id.fibonacci_result_tv)
    }

    fun onClick(view: View) {
        if (!numberEt.text.isNullOrEmpty()){
            val n = numberEt.text.toString().toInt()
            val fibNumber = Fibonacci().fibCalc(n)
            resultTv.text = fibNumber.toString()
        }
    }
}