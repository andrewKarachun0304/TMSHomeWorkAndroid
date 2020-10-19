package com.andrewKarachun0304.tmshomeworkandroid.hw6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.andrewKarachun0304.tmshomeworkandroid.R
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import kotlinx.android.synthetic.main.activity_home_work6.*
import kotlinx.coroutines.*

class HomeWork6Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_work6)

        start_animation_btn.setOnClickListener {
            start_animation_btn.isEnabled = false
            CoroutineScope(Dispatchers.IO).launch {
                anim1()
            }
        }
    }

    private fun anim4() {
        flowers_iv.visibility = View.VISIBLE
        YoYo.with(Techniques.Flash)
            .duration(2000)
            .onEnd {
                start_animation_btn.isEnabled = true
            }
            .playOn(flowers_iv)

    }

    private fun anim3() {
        congratulation_part3_tv.visibility = View.VISIBLE
        YoYo.with(Techniques.BounceInLeft)
            .duration(1000)
            .onEnd {
                anim4()
            }
            .playOn(congratulation_part3_tv)

    }

    private fun anim2() {
        congratulation_part2_tv.visibility = View.VISIBLE
        YoYo.with(Techniques.BounceInRight)
            .duration(1000)
            .onEnd {
                anim3()
            }
            .playOn(congratulation_part2_tv)

    }

    private suspend fun anim1() {
        withContext(Dispatchers.Main) {
            congratulation_part1_tv.visibility = View.VISIBLE
            YoYo.with(Techniques.BounceInLeft)
                .duration(1000)
                .onEnd {
                    anim2()
                }
                .playOn(congratulation_part1_tv)
        }
    }
}