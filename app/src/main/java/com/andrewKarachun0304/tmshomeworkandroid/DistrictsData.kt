package com.andrewKarachun0304.tmshomeworkandroid

import androidx.lifecycle.MutableLiveData

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