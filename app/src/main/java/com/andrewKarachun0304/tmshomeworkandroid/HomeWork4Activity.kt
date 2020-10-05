package com.andrewKarachun0304.tmshomeworkandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

class HomeWork4Activity : AppCompatActivity(),
    AddCoffeeFragment.ButtonOnClickListener,
    AllCoffeeListFragment.FragmentOnCreateListener {
        private val myViewModel by lazy {
            ViewModelProvider(this).get(CoffeeViewModel::class.java)
        }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_home_work4)
        }

        override fun onClickAddCoffee(coffee: Coffee) {
            myViewModel.addCoffee(coffee)
            Toast.makeText(this, "Coffee added", Toast.LENGTH_SHORT).show()
        }

        override fun getCoffeeList() = myViewModel.getCoffeeList()
}