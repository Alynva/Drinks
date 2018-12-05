package com.alynva.drinks.drinks.scenarios.main


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.alynva.drinks.drinks.R
import com.alynva.drinks.drinks.entities.Drink
import com.alynva.drinks.drinks.entities.Ingredient
import com.alynva.drinks.drinks.utils.GlideApp
import kotlinx.android.synthetic.main.fragment_drinks_detail.*
import kotlinx.android.synthetic.main.fragment_drinks_list.*


class DrinksDetailFragment : Fragment() {

    companion object {

        private val ARG_DRINK = "arg_drink"

        fun newInstance(drink : Drink) =
                DrinksDetailFragment().apply {
                    arguments = Bundle().apply {
                        putSerializable(ARG_DRINK, drink)
                    }
                }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_drinks_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val drink = getDrink()

        activity?.let { that ->
            GlideApp.with(that)
                    .load(drink.strDrinkThumb)
                    .placeholder(R.drawable.no_image_icon_4)
                    .centerCrop()
                    .into(iv_drink_detail_img)
        }

        tv_drink_detail_nome.text = drink.strDrink
        tv_drink_detail_id.text = "#${drink.idDrink.toString()}"
        tv_drink_detail_cat_alco.text = "${drink.strCategory} • ${drink.strAlcoholic}"
        tv_drink_detail_glass.text = drink.strGlass
        tv_drink_detail_instru.text = drink.strInstructions
        tv_drink_detail_date.text = drink.dateModified


        val ingredients = listOf(
                Ingredient(drink.strIngredient1!!,
                        drink.strMeasure1!!),
                Ingredient(drink.strIngredient2!!,
                        drink.strMeasure2!!),
                Ingredient(drink.strIngredient3!!,
                        drink.strMeasure3!!),
                Ingredient(drink.strIngredient4!!,
                        drink.strMeasure4!!),
                Ingredient(drink.strIngredient5!!,
                        drink.strMeasure5!!),
                Ingredient(drink.strIngredient6!!,
                        drink.strMeasure6!!),
                Ingredient(drink.strIngredient7!!,
                        drink.strMeasure7!!),
                Ingredient(drink.strIngredient8!!,
                        drink.strMeasure8!!),
                Ingredient(drink.strIngredient9!!,
                        drink.strMeasure9!!),
                Ingredient(drink.strIngredient10!!,
                        drink.strMeasure10!!),
                Ingredient(drink.strIngredient11!!,
                        drink.strMeasure11!!),
                Ingredient(drink.strIngredient12!!,
                        drink.strMeasure12!!),
                Ingredient(drink.strIngredient13!!,
                        drink.strMeasure13!!),
                Ingredient(drink.strIngredient14!!,
                        drink.strMeasure14!!),
                Ingredient(drink.strIngredient15!!,
                        drink.strMeasure15!!)
        )

        loadIngredientsList(ingredients)

    }

    private fun loadIngredientsList(ingredients: List<Ingredient>) {

        activity.let { that ->

            val adapter = IngredientAdapter(ingredients)

            val layoutManager = LinearLayoutManager(that)

            rvIngredients.adapter = adapter
            rvIngredients.layoutManager = layoutManager
        }

    }

    fun getDrink() : Drink {
        val drink = arguments?.getSerializable(ARG_DRINK) as Drink?
        if (drink == null) {
            throw NullPointerException("Drink can not be null")
        }
        return drink
    }
}
