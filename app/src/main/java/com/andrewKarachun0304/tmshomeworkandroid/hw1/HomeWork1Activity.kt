package com.andrewKarachun0304.tmshomeworkandroid.hw1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.andrewKarachun0304.tmshomeworkandroid.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_home_work1.*

class HomeWork1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_work1)

        loadImageBtn.setOnClickListener {
            showImage()
        }
    }

    private fun showImage() {
        if (imageUrlET.text.isEmpty()) {
            Toast.makeText(this, "Please, enter image URL address!", Toast.LENGTH_SHORT).show()
            return
        }
        Picasso
            .get()
            .load(imageUrlET.text.toString())
            .into(loadImageIV)
    }
}