package com.mahesaiqbal.myviewmodel.view

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mahesaiqbal.myviewmodel.R
import com.mahesaiqbal.myviewmodel.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        displayResult()
        calculate()
    }

    private fun calculate() {
        btn_calculate.setOnClickListener { v -> startCalculate() }
    }

    private fun startCalculate() {
        val width = edt_width.text.toString()
        val height = edt_height.text.toString()
        val length = edt_length.text.toString()

        if (width.isEmpty()) {
            edt_width.error = "Masih kosong"
        } else if (height.isEmpty()) {
            edt_height.error = "Masih kosong"
        } else if (length.isEmpty()) {
            edt_length.error = "Masih kosong"
        } else {
            viewModel.calculate(width, height, length)
            displayResult()
        }
    }

    fun displayResult() {
        tv_result.text = viewModel.result.toString()
    }
}
