package com.andrewKarachun0304.tmshomeworkandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_home_work1.*

class HomeWork1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_work1)
    }

    fun loadImageOnClick(view: View) {
        if (imageUrlET.text.isEmpty()) {
            Toast.makeText(this, "Please, enter image URL", Toast.LENGTH_SHORT).show()
            return
        }

        Picasso
            .get()
            .load(imageUrlET.text.toString())
            .into(loadImageIV)
    }
}