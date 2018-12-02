package com.alynva.drinks.drinks.scenarios_splash

import com.alynva.drinks.drinks.entities.Drink

interface SplashContract {

    interface View {
        fun saveList(drinks: List<Drink>)
        fun showMessage(msg: String)
        fun hideLoader()
        fun showLoader()

    }

    interface Presenter {
        fun onLoadList()
    }
}