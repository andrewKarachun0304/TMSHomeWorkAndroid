package com.andrewKarachun0304.tmshomeworkandroid.hw3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.andrewKarachun0304.tmshomeworkandroid.R
import kotlinx.android.synthetic.main.activity_harvest_h_w4.*

class HarvestActivityHW4 : AppCompatActivity() {
    private val harvestingViewModel by lazy {
        ViewModelProvider(this).get(HarvestingViewModel::class.java)
    }
    private val potatoesListTV by lazy {
        listOf(
            potatoes_distr1_tv,
            potatoes_distr2_tv,
            potatoes_distr3_tv,
            potatoes_distr4_tv,
            potatoes_distr5_tv,
            potatoes_distr6_tv
        )
    }
    private val cabbageListTV by lazy {
        listOf(
            cabbage_distr1_tv,
            cabbage_distr2_tv,
            cabbage_distr3_tv,
            cabbage_distr4_tv,
            cabbage_distr5_tv,
            cabbage_distr6_tv
        )
    }
    private val beetListTV by lazy {
        listOf(
            beet_distr1_tv,
            beet_distr2_tv,
            beet_distr3_tv,
            beet_distr4_tv,
            beet_distr5_tv,
            beet_distr6_tv
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_harvest_h_w4)

        initViewModel()
    }

    fun homeWork4BtnOnClick(view: View) {
        when (view.id) {
            R.id.start_btn -> harvestingViewModel.userClickedStart()
            R.id.cancel_btn -> harvestingViewModel.userClickCancel()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun initViewModel() {
        for (i in potatoesListTV.indices) {
            harvestingViewModel.districtsList[i].harvest.observe(this, { harvest ->
                with(harvest) {
                    potatoesListTV[i].text = "$potatoes Ton"
                    cabbageListTV[i].text = "$cabbage Ton"
                    beetListTV[i].text = "$beet Ton"
                }
            })
        }
        harvestingViewModel.winner.observe(this, { winner ->
            winner_tv.text = winner
        })
        harvestingViewModel.isWinner.observe(this, { isWinner ->
            if (isWinner) {
                harvestingViewModel.whoWin()
            }
        })
    }
}