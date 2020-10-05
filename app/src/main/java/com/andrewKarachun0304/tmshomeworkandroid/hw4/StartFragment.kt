package com.andrewKarachun0304.tmshomeworkandroid.hw4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.andrewKarachun0304.tmshomeworkandroid.R
import kotlinx.android.synthetic.main.fragment_start.*

class StartFragment : Fragment() {

    private val nav by lazy { findNavController() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        add_kind_of_coffee_btn.setOnClickListener {
            nav.navigate(R.id.show_addCoffeeFragment)
        }

        show_all_kind_of_coffee_btn.setOnClickListener {
            nav.navigate(R.id.show_allCoffeeListFragment)
        }
    }


}