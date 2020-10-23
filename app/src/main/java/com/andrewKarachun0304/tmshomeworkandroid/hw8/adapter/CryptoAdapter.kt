package com.andrewKarachun0304.tmshomeworkandroid.hw8.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andrewKarachun0304.tmshomeworkandroid.R
import com.andrewKarachun0304.tmshomeworkandroid.hw8.LogoPath
import com.andrewKarachun0304.tmshomeworkandroid.hw8.entity.Crypto
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.crypto_item.view.*

class CryptoAdapter: RecyclerView.Adapter<CryptoAdapter.CryptoVH>() {

    private var cryptoList = ArrayList<Crypto>()

    fun updateList(list: List<Crypto>?){
        cryptoList = list as ArrayList<Crypto>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.crypto_item, parent, false)
        return CryptoVH(view)
    }

    override fun onBindViewHolder(holder: CryptoVH, position: Int) {
        holder.bind(cryptoList[position])
    }

    override fun getItemCount() = cryptoList.size

    class CryptoVH(itemView: View): RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(crypto: Crypto){
            with(itemView){
                crypto_name_tv.text = crypto.name
                crypto_price_tv.text = "${crypto.price} $"
                crypto_change_tv.text = "${crypto.change} %"
                if (crypto.change > 0){
                    crypto_change_tv.setTextColor(resources.getColor(R.color.green_custom_color, resources.newTheme()))
                } else {
                    crypto_change_tv.setTextColor(resources.getColor(R.color.red_custom_color, resources.newTheme()))
                }
                Picasso.get().load(LogoPath.logoMap[crypto.name]).into(crypto_civ)
            }
        }
    }
}