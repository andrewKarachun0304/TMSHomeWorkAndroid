package com.andrewKarachun0304.tmshomeworkandroid

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class HarvestingViewModel : ViewModel() {
    val districtsList = DistrictsData.getDistrictsData()
    val winner = MutableLiveData("")
    val isWinner = MutableLiveData(false)

    private val updateHarvestJob by lazy {
        CoroutineScope(Dispatchers.IO).launch {
            while (isActive) {
                delay(1000)
                for (district in districtsList) {
                    district.updateHarvestResult()
                }
            }
        }
    }

    private val whoWinCheckJob by lazy {
        CoroutineScope(Dispatchers.IO).launch {
            while (isActive){
                for (district in districtsList){
                    if (district.winCheck()) {
                        isWinner.postValue(true)
                        updateHarvestJob.cancel()
                        return@launch
                    }
                }
                delay(500)
            }
        }
    }

    fun whoWin(){
        var max = 0
        var winnerName = ""
        for (district in districtsList){
            if (district.generalSum > max){
                max = district.generalSum
                winnerName = district.name
            }
        }
        winner.postValue("$winnerName win!!!")
    }

    fun userClickedStart() {
        updateHarvestJob.start()
        whoWinCheckJob.start()
    }

    fun userClickCancel() {
        updateHarvestJob.cancel()
        whoWinCheckJob.cancel()
    }
}