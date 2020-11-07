package com.example.todayscocktail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.todayscocktail.repository.CocktailsListRepository
import com.example.todayscocktail.viewModel.CocktailsListViewModel
import com.example.todayscocktail.viewModel.CocktailsListViewModelFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModelFactory = CocktailsListViewModelFactory(CocktailsListRepository())
        val viewModel = ViewModelProvider(this, viewModelFactory).get(CocktailsListViewModel::class.java)
        val list = viewModel.cocktailList
        list.observe(this, Observer {
            findViewById<TextView>(R.id.textView).text = it[0].name
        })
    }
}
