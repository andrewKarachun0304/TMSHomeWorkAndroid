package com.andrewKarachun0304.tmshomeworkandroid.hw3

import androidx.lifecycle.MutableLiveData
import com.andrewKarachun0304.tmshomeworkandroid.hw3.Harvest
import kotlin.math.roundToInt

class Districts(
    val name: String,
    var harvest: MutableLiveData<Harvest>
) {
    var generalSum = 0

    fun updateHarvestResult() {
        val harvest = Harvest(
            harvest.value?.potatoes ?: 0,
            harvest.value?.cabbage ?: 0,
            harvest.value?.beet ?: 0
        )
        harvest.potatoes += (Math.random() * 14 + 1).roundToInt()
        harvest.cabbage += (Math.random() * 14 + 1).roundToInt()
        harvest.beet += (Math.random() * 14 + 1).roundToInt()

        this.harvest.postValue(harvest)
        generalSum = harvest.generalSum()
    }

    fun winCheck() = harvest.value?.checkNormal() ?: false
}