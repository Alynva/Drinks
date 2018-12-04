package com.alynva.drinks.drinks.scenarios.main

import android.content.Context
import com.alynva.drinks.drinks.entities.Drink

interface MainContract {

    interface View {
        fun showList(list: List<Drink>)
        fun showDetails(drink: Drink)
        fun showLoader()
        fun hideLoader()
        fun showMessage(msg : String)
        fun saveDrink(drink: Drink)
    }

    interface Presenter {
        fun onLoadList(context: Context)
        fun onUpdateDetails(context: Context, idDrink: Int)
        fun onLoadDetails(context: Context, idDrink: Int)
        fun onLoadRandom(context: Context)
    }

}