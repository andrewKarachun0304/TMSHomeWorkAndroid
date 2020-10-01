package com.andrewKarachun0304.tmshomeworkandroid

import androidx.lifecycle.ViewModel
import java.util.*

class CoffeeViewModel: ViewModel() {
    private val coffeeList = LinkedList<Coffee>()

    fun addCoffee(coffee: Coffee) {
        coffeeList.addLast(coffee)
    }

    fun getCoffeeList() = coffeeList
}