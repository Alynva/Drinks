package com.alynva.drinks.drinks.scenarios.main

import android.content.Context
import com.alynva.drinks.drinks.database.AppDatabase
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter(val view: MainContract.View): MainContract.Presenter {
    override fun onUpdateList(context: Context) {
        val drinksDao = AppDatabase.getInstance(context).drinkDao()
        doAsync {
            val drinks = drinksDao.getAll()

            uiThread {
                view.showList(drinks)
            }
        }
    }

}