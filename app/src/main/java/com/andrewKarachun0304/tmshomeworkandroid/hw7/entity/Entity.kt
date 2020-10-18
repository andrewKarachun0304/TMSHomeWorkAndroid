package com.andrewKarachun0304.tmshomeworkandroid.hw7.entity

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun launchIO(task: suspend () -> Unit){
    CoroutineScope(Dispatchers.IO).launch {
        task()
    }
}

fun launchUI(task: suspend () -> Unit){
    CoroutineScope(Dispatchers.Main).launch {
        task()
    }
}