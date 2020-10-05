package com.andrewKarachun0304.tmshomeworkandroid

class Harvest(
    var potatoes: Int,
    var cabbage: Int,
    var beet: Int
) {
    fun checkNormal() = potatoes >= 100 && cabbage >= 100 && beet >= 100

    fun generalSum() = potatoes + cabbage + beet
}