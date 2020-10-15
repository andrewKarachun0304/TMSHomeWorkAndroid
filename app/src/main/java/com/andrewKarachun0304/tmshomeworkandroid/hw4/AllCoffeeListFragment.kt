package com.andrewKarachun0304.tmshomeworkandroid.hw4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.andrewKarachun0304.tmshomeworkandroid.R
import kotlinx.android.synthetic.main.fragment_all_coffee_list.*
import java.util.*

class AllCoffeeListFragment : Fragment() {

    interface FragmentOnCreateListener{
        fun getCoffeeList(): List<Coffee>
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_all_coffee_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initCoffeeRV()
    }

    private fun initCoffeeRV(){
        val listener = context as FragmentOnCreateListener
        val adapter = CoffeeListAdapter()
        coffee_list_rv.adapter = adapter
        coffee_list_rv.layoutManager = LinearLayoutManager(context)
        adapter.updateCoffeeList(listener.getCoffeeList() as LinkedList<Coffee>)
    }
}