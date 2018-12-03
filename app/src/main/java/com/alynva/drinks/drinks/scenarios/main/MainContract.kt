package com.alynva.drinks.drinks.scenarios.main

import android.content.Context
import com.alynva.drinks.drinks.entities.Drink

interface MainContract {

    interface View {
        fun showList(list: List<Drink>)
    }

    interface Presenter {
        fun onUpdateList(context: Context)

    }

}