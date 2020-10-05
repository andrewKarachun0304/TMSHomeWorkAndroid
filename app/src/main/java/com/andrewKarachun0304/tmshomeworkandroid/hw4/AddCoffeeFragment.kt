package com.andrewKarachun0304.tmshomeworkandroid.hw4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.andrewKarachun0304.tmshomeworkandroid.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_add_coffee.*

class AddCoffeeFragment : Fragment() {
    interface ButtonOnClickListener {
        fun onClickAddCoffee(coffee: Coffee)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_coffee, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initLoadImageBtn()
        initAddNewCoffeeBtn()
    }

    private fun initLoadImageBtn() {
        load_image_btn.setOnClickListener {
            if (image_url_coffee_et.text.isNotEmpty()) {
                loadImage(image_url_coffee_et.text.toString())
            } else{
                show_message_tv.text = resources.getString(R.string.fill_url_fields)
            }
        }
    }

    private fun initAddNewCoffeeBtn() {
        add_new_coffee_btn.setOnClickListener {
            if (sort_coffee_et.text.isEmpty() || price_coffee_et.text.isEmpty() || image_url_coffee_et.text.isEmpty()) {
                show_message_tv.text = resources.getString(R.string.fill_all_fields)
            } else {
                addImageToList()
            }
        }
    }

    private fun addImageToList() {
        val listener = context as ButtonOnClickListener
        listener.onClickAddCoffee(
            Coffee(
                sort_coffee_et.text.toString(),
                price_coffee_et.text.toString().toDouble(),
                image_url_coffee_et.text.toString()
            )
        )
        val nav = findNavController()
        nav.popBackStack()
    }

    private fun loadImage(url: String) {
        Picasso.get().load(url).into(coffee_iv)
    }
}