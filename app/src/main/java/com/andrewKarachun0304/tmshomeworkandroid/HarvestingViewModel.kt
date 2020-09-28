package com.andrewKarachun0304.tmshomeworkandroid

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlin.math.roundToLong

class HarvestingViewModel : ViewModel() {
    var districtsList = DistrictsData.getDistrictsData()
    val winner = MutableLiveData("")
    private var flag = false

    private val job by lazy {
        CoroutineScope(Dispatchers.IO).launch {
            while (isActive) {
                delay(1000)
                for (district in districtsList) {
                    district.updateHarvestResult((Math.random() * 4000 + 1000).roundToLong())
                }
            }
        }
    }

    private val whoWinCheckJob by lazy {
        CoroutineScope(Dispatchers.IO).launch {
            while (isActive){
                for (district in districtsList){
                    if (district.whoWinCheck()) {
                        winner.postValue("${district.name} win!!!")
                        job.cancel()
                        return@launch
                    }
                }
                delay(500)
            }
        }
    }


    fun userClickedStart() {
        flag = true
        job.start()
        whoWinCheckJob.start()
    }

    fun userClickCancel() {
        flag = false
        job.cancel()
        whoWinCheckJob.cancel()
    }
}