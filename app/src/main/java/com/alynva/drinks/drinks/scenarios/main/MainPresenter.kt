package com.alynva.drinks.drinks.scenarios.main

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.alynva.drinks.drinks.database.AppDatabase
import com.alynva.drinks.drinks.entities.Drink
import com.alynva.drinks.drinks.entities.DrinksList
import com.alynva.drinks.drinks.network.RetrofitInicializer
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(val view: MainContract.View): MainContract.Presenter {
    override fun onLoadList(context: Context) {
        val drinksDao = AppDatabase.getInstance(context).drinkDao()
        doAsync {
            val drinks = drinksDao.getAll()

            uiThread {
                view.showList(drinks)
            }
        }
    }

    override fun onUpdateDetails(context: Context, idDrink: Int) {
        view.showLoader()

        val drinksService = RetrofitInicializer().createDrinksService()

        val call = drinksService.getDrinkById(idDrink.toString())

        call.enqueue(object : Callback<DrinksList> {
            override fun onResponse(call: Call<DrinksList>?, response: Response<DrinksList>?) {
                view.hideLoader()
                if (response?.body() != null) {
                    Log.d("details", "Eu mandei o drink ${response.body()!!.drinks[0].strDrink} ser salvo")
                    view.saveDrink(response.body()!!.drinks[0])
                } else {
                    view.showMessage("O drink não foi encontrado.")
                }
            }

            override fun onFailure(call: Call<DrinksList>?, t: Throwable?) {
                view.hideLoader()
                view.showMessage("Falha na conexão. Verifique o acesso a internet.")
            }
        })
    }
    override fun onLoadDetails(context: Context, idDrink: Int) {
        val drinksDao = AppDatabase.getInstance(context).drinkDao()
        Log.d("details", "Detalhes querem ser carregados $idDrink")
        view.showLoader()
        doAsync {
            val drink = drinksDao.getDrink(idDrink)
            Log.d("details", "$idDrink carregado")
            uiThread {
                view.hideLoader()
                view.showDetails(drink)
            }
        }
    }

}