package com.alynva.drinks.drinks.scenarios.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alynva.drinks.drinks.R
import com.alynva.drinks.drinks.entities.Ingredient
import kotlinx.android.synthetic.main.list_ingredient_item.view.*

class IngredientAdapter(val ingredients: List<Ingredient>) : RecyclerView.Adapter<IngredientAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return ingredients.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_ingredient_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(ingredients[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(ingredient: Ingredient) {
            itemView.tv_ingredient_name.text = ingredient.strIngredient
            itemView.tv_ingredient_measure.text = ingredient.strMeasure
        }
    }
}