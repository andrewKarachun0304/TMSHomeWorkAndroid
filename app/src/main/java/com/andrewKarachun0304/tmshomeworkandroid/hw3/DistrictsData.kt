package com.andrewKarachun0304.tmshomeworkandroid.hw3

import androidx.lifecycle.MutableLiveData
import com.andrewKarachun0304.tmshomeworkandroid.hw3.Districts
import com.andrewKarachun0304.tmshomeworkandroid.hw3.Harvest

object DistrictsData {
    fun getDistrictsData() = listOf(
            Districts("Minsk", MutableLiveData(Harvest(0, 0, 0))),
            Districts("Brest", MutableLiveData(Harvest(0, 0, 0))),
            Districts("Vitebsk", MutableLiveData(Harvest(0, 0, 0))),
            Districts("Grodno", MutableLiveData(Harvest(0, 0, 0))),
            Districts("Gomel", MutableLiveData(Harvest(0, 0, 0))),
            Districts("Mogilev", MutableLiveData(Harvest(0, 0, 0)))
    )
}