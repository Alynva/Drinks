package com.alynva.drinks.drinks.scenarios_splash

import android.widget.Toast
import com.alynva.drinks.drinks.entities.DrinksList
import com.alynva.drinks.drinks.network.RetrofitInicializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SplashPresenter(val view : SplashContract.View) : SplashContract.Presenter {

    override fun onLoadList() {

        view.showLoader()

        val drinksService = RetrofitInicializer().createDrinksService()

        val call = drinksService.getAlcoholicDrinks()

        call.enqueue(object : Callback<DrinksList> {
            override fun onResponse(call: Call<DrinksList>?, response: Response<DrinksList>?) {
                view.hideLoader()
                if (response?.body() != null) {
                    view.saveList(response.body()!!.drinks)
                } else {
                    view.showMessage("Não há drinks para serem listados.")
                }
            }

            override fun onFailure(call: Call<DrinksList>?, t: Throwable?) {
                view.hideLoader()
                view.showMessage("Falha na conexão. Verifique o acesso a internet.")
            }
        })

    }
}