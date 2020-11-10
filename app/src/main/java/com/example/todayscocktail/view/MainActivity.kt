package com.example.todayscocktail.view

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.todayscocktail.R
import com.example.todayscocktail.databinding.ActivityMainBinding
import com.example.todayscocktail.data.CocktailDatabase
import com.example.todayscocktail.network.CocktailsApi
import com.example.todayscocktail.repository.CocktailsListRepository
import com.example.todayscocktail.viewModel.CocktailsListViewModel
import com.example.todayscocktail.viewModel.CocktailsListViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val databaseDao = CocktailDatabase.getDatabase(this, CoroutineScope(Dispatchers.IO)).cocktailDao()
        val remoteService = CocktailsApi.retrofitService
        val repository = CocktailsListRepository(databaseDao, remoteService)

        val viewModelFactory = CocktailsListViewModelFactory(repository)

        val viewModel = ViewModelProvider(this, viewModelFactory).get(CocktailsListViewModel::class.java)
        val list = viewModel.cocktailList

        val recyclerView = findViewById<RecyclerView>(R.id.items_recycle_view)
        val adapter = DrinkItemAdapter()
        recyclerView.adapter = adapter

        list.observe(this, Observer {
            adapter.data = it
            recyclerView.visibility = View.VISIBLE
            findViewById<ProgressBar>(R.id.loadingDrinksIndicator).visibility = View.GONE
        })
    }
}