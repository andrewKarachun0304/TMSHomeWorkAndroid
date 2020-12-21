package com.andrewKarachun0304.tmshomeworkandroid.hw12

class Fibonacci {
    fun fibCalc(n: Int): Int {
        return when {
            n in 0..1 -> n
            n < 0 -> 0
            else -> fibCalc(n - 1) + fibCalc(n - 2)
        }
    }
}