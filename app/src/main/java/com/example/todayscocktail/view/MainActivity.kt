package com.example.todayscocktail.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.todayscocktail.R
import com.example.todayscocktail.databinding.ActivityMainBinding
import com.example.todayscocktail.repository.CocktailsListRepository
import com.example.todayscocktail.viewModel.CocktailsListViewModel
import com.example.todayscocktail.viewModel.CocktailsListViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recycleView = binding.itemsRecycleView
        val adapter = DrinkItemAdapter()
        recycleView.adapter = adapter

        val viewModelFactory = CocktailsListViewModelFactory(CocktailsListRepository())
        val viewModel = ViewModelProvider(this, viewModelFactory).get(CocktailsListViewModel::class.java)
        val list = viewModel.cocktailList
        list.observe(this, Observer {
            val imageView = findViewById<ImageView>(R.id.drink_image);
            Glide.with(this)
                .load(it[0].thumbUrl)
                .into(imageView)
            findViewById<TextView>(R.id.drink_name).text = it[0].thumbUrl
        })
    }
}
