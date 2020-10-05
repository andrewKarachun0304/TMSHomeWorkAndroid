package com.andrewKarachun0304.tmshomeworkandroid

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import java.util.*

class CoffeeListAdapter: RecyclerView.Adapter<CoffeeListAdapter.CoffeeVH>() {
    var coffeeList = LinkedList<Coffee>()

    fun updateCoffeeList(list: LinkedList<Coffee>){
        coffeeList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.coffee_item, parent, false)
        return CoffeeVH(view)
    }

    override fun onBindViewHolder(holder: CoffeeVH, position: Int) {
        holder.bind(coffeeList[position])
    }

    override fun getItemCount() = coffeeList.size

    class CoffeeVH(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val coffeeIV: ImageView
        private val coffeeName: TextView
        private val coffeePrice: TextView

        init {
            with(itemView){
                coffeeIV = findViewById(R.id.coffee_iv_item)
                coffeeName = findViewById(R.id.coffee_name_tv_item)
                coffeePrice = findViewById(R.id.coffee_price_tv_item)
            }
        }

        @SuppressLint("SetTextI18n")
        fun bind(coffee: Coffee){
            Picasso.get().load(coffee.imageUrl).into(coffeeIV)
            coffeeName.text = "Name: ${coffee.name}"
            coffeePrice.text = "Price ${coffee.price.toString()}"
        }
    }
}