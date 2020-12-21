package com.andrewKarachun0304.tmshomeworkandroid.hw12

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class FibonacciTest{
    private lateinit var fibonacci: Fibonacci

    @Before
    fun setUp(){
        fibonacci = Fibonacci()
    }

    @Test
    fun fibonacciCalculate0Number_isTrue(){
        val result = fibonacci.fibCalc(0)
        assertEquals(result, 0)
    }

    @Test
    fun fibonacciCalculate1Number_isTrue(){
        val result = fibonacci.fibCalc(1)
        assertEquals(result, 1)
    }

    @Test
    fun fibonacciCalculate5Number_isTrue(){
        val result = fibonacci.fibCalc(5)
        assertEquals(result, 5)
    }

    @Test
    fun fibonacciCalculate7Number_isTrue(){
        val result = fibonacci.fibCalc(7)
        assertEquals(result, 13)
    }
    @Test
    fun fibonacciCalculateMinus1Number_isTrue(){
        val result = fibonacci.fibCalc(-1)
        assertEquals(result, 0)
    }
}