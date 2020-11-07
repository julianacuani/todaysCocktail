package com.example.todayscocktail.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todayscocktail.network.Cocktail
import com.example.todayscocktail.R
import java.lang.reflect.Array.set

class DrinkItemAdapter: RecyclerView.Adapter<DrinkItemAdapter.DrinkItemViewHolder>(){
    var data = listOf<Cocktail>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    inner class DrinkItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val drinkName: TextView = itemView.findViewById(R.id.drink_name)
        val drinkImage: TextView = itemView.findViewById(R.id.drink_image)

        fun bind(name: String, image: ImageView) {
            drinkName.text = name
            drinkImage.text = image
        }
    }
