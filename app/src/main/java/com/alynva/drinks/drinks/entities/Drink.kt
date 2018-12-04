package com.alynva.drinks.drinks.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

@Entity
data class Drink(@PrimaryKey
                 val idDrink: Int,
                 val strDrink: String,
                 val strDrinkThumb: String,
                 val strCategory: String? = null,
                 val strAlcoholic: String? = null,
                 val strGlass: String? = null,
                 val strInstructions: String? = null,
                 val strIngredient1: String? = null,
                 val strMeasure1: String? = null) : Serializable