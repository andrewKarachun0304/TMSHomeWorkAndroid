package com.andrewKarachun0304.tmshomeworkandroid

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.delay
import kotlin.math.roundToInt

class Districts(
    val name: String,
    var harvest: MutableLiveData<Harvest>
) {
    suspend fun updateHarvestResult(duration: Long) {
        val harvest = Harvest(
            harvest.value?.potatoes ?: 0,
            harvest.value?.cabbage ?: 0,
            harvest.value?.beet ?: 0
        )
        harvest.potatoes += (Math.random() * 14 + 1).roundToInt()
        harvest.cabbage += (Math.random() * 14 + 1).roundToInt()
        harvest.beet += (Math.random() * 14 + 1).roundToInt()

        this.harvest.postValue(harvest)
//        delay(duration)
    }

    fun whoWinCheck() = harvest.value?.checkNormal() ?: false
}