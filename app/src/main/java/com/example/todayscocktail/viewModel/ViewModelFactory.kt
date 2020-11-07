package com.example.todayscocktail.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.todayscocktail.repository.CocktailsListRepository

//Fábrica de objetos
class ViewModelFactory(private val repository: CocktailsListRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CocktailsListViewModel::class.java)) {
            return CocktailsListViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
