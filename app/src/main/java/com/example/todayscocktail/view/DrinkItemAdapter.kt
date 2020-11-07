package com.example.todayscocktail.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.todayscocktail.network.Cocktail
import com.example.todayscocktail.R

class DrinkItemAdapter: RecyclerView.Adapter<DrinkItemAdapter.DrinkItemViewHolder>(){
    var data = listOf<Cocktail>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    inner class DrinkItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val drinkName: TextView = itemView.findViewById(R.id.drink_name)
        val list: ImageView = itemView.findViewById(R.id.drink_image)

        fun bind(name: String, imageURL: String) {
            drinkName.text = name

             val imageView = list;
              Glide.with(itemView.context)
                 .load(imageURL)
                 .into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.cocktails_drinks, parent, false)
        return DrinkItemViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: DrinkItemViewHolder, position: Int) {
        val cocktailToShow: Cocktail = data.get(position)
        holder.bind(cocktailToShow.name, cocktailToShow.thumbUrl)
    }
}
