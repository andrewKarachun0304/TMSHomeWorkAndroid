package com.andrewKarachun0304.tmshomeworkandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_harvest_h_w4.*

class HarvestActivityHW4 : AppCompatActivity() {
    private lateinit var harvestingViewModel: HarvestingViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_harvest_h_w4)

        harvestingViewModel = ViewModelProvider(this).get(HarvestingViewModel::class.java)
        harvestingViewModel.districtsList[0].harvest.observe(this, {
            with(it) {
                potatoes_distr1_tv.text = "$potatoes Ton"
                cabbage_distr1_tv.text = "$cabbage Ton"
                beet_distr1_tv.text = "$beet Ton"
            }
        })
        harvestingViewModel.districtsList[1].harvest.observe(this, {
            with(it) {
                potatoes_distr2_tv.text = "$potatoes Ton"
                cabbage_distr2_tv.text = "$cabbage Ton"
                beet_distr2_tv.text = "$beet Ton"
            }
        })
        harvestingViewModel.districtsList[2].harvest.observe(this, {
            with(it) {
                potatoes_distr3_tv.text = "$potatoes Ton"
                cabbage_distr3_tv.text = "$cabbage Ton"
                beet_distr3_tv.text = "$beet Ton"
            }
        })
        harvestingViewModel.districtsList[3].harvest.observe(this, {
            with(it) {
                potatoes_distr4_tv.text = "$potatoes Ton"
                cabbage_distr4_tv.text = "$cabbage Ton"
                beet_distr4_tv.text = "$beet Ton"
            }
        })
        harvestingViewModel.districtsList[4].harvest.observe(this, {
            with(it) {
                potatoes_distr5_tv.text = "$potatoes Ton"
                cabbage_distr5_tv.text = "$cabbage Ton"
                beet_distr5_tv.text = "$beet Ton"
            }
        })
        harvestingViewModel.districtsList[5].harvest.observe(this, {
            with(it) {
                potatoes_distr6_tv.text = "$potatoes Ton"
                cabbage_distr6_tv.text = "$cabbage Ton"
                beet_distr6_tv.text = "$beet Ton"
            }
        })
        harvestingViewModel.winner.observe(this, {
            winner_tv.text = "$it Win!!!"
        })
    }

    fun homeWork4BtnOnClick(view: View) {
        when (view.id) {
            R.id.start_btn -> harvestingViewModel.userClickedStart()
            R.id.cancel_btn -> harvestingViewModel.userClickCancel()
        }

    }
}