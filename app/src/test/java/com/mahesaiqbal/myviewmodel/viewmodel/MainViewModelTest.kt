package com.mahesaiqbal.myviewmodel.viewmodel

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before



class MainViewModelTest {

    private var mainViewModel: MainViewModel? = null

    @Before
    fun init() {
        mainViewModel = MainViewModel()
    }

    @Test
    fun calculate() {
        val width = "1"
        val length = "2"
        val height = "3"

        mainViewModel?.calculate(width, height, length)
        assertEquals(6, mainViewModel?.result)
    }
}