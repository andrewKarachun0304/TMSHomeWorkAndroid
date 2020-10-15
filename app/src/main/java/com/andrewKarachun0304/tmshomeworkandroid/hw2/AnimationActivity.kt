package com.andrewKarachun0304.tmshomeworkandroid.hw2

import android.graphics.BitmapFactory
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.andrewKarachun0304.tmshomeworkandroid.R
import kotlinx.android.synthetic.main.activity_animation.*

class AnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)

        createCatAnimation()
    }

    private fun createCatAnimation(){
        val animation = AnimationDrawable()

        val bitMapList = listOf(
            BitmapFactory.decodeResource(resources, R.drawable.cat0),
            BitmapFactory.decodeResource(resources, R.drawable.cat1),
            BitmapFactory.decodeResource(resources, R.drawable.cat2),
            BitmapFactory.decodeResource(resources, R.drawable.cat3)
        )
        val frameList = listOf(
            BitmapDrawable(resources, bitMapList[0]),
            BitmapDrawable(resources, bitMapList[1]),
            BitmapDrawable(resources, bitMapList[2]),
            BitmapDrawable(resources, bitMapList[3])
        )

        animation.isOneShot = false
        animation.addFrame(frameList[0], 250)
        animation.addFrame(frameList[1], 250)
        animation.addFrame(frameList[2], 250)
        animation.addFrame(frameList[3], 250)

        animationIV.background = animation
        animationIV.scaleType = ImageView.ScaleType.CENTER_INSIDE
        animation.setVisible(true, true)
        animation.start()
    }
}