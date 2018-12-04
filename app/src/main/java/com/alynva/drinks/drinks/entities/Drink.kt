package com.alynva.drinks.drinks.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

@Entity
data class Drink(@PrimaryKey
                 val idDrink: Int,
                 val strDrink: String,
                 val strDrinkThumb: String,
                 val strCategory: String?,
                 val strAlcoholic: String?,
                 val strGlass: String?,
                 val strInstructions: String?,
                 val strIngredient1: String?,
                 val strMeasure1: String?) : Serializable