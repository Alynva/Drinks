package com.alynva.drinks.drinks.scenarios.main


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.alynva.drinks.drinks.R
import com.alynva.drinks.drinks.entities.Drink
import com.alynva.drinks.drinks.utils.GlideApp
import kotlinx.android.synthetic.main.fragment_drinks_detail.*


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
        tv_drink_detail_instru.text = drink.strInstructions

    }

    fun getDrink() : Drink {
        val drink = arguments?.getSerializable(ARG_DRINK) as Drink?
        if (drink == null) {
            throw NullPointerException("Drink can not be null")
        }
        return drink
    }
}
