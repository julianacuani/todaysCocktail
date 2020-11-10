package com.example.todayscocktail.network

import com.example.todayscocktail.entity.Cocktail
import com.squareup.moshi.Json

data class CocktailsResponse (
    @Json(name = "drinks")
    val cocktailsList: List<Cocktail>)