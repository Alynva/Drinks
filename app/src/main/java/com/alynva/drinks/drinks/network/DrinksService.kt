package com.alynva.drinks.drinks.network

import com.alynva.drinks.drinks.entities.DrinksList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinksService {

    @GET("lookup.php?")
    fun getDrinkById(@Query("i") id : String): Call<DrinksList>
            //https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=13060

    @GET("random.php")
    fun getRandomDrink(): Call<DrinksList>

    @GET("filter.php?a=Alcoholic")
    fun getAlcoholicDrinks(): Call<DrinksList>
}