package com.alynva.drinks.drinks.scenarios.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ProgressBar
import android.widget.Toast
import com.alynva.drinks.drinks.R
import com.alynva.drinks.drinks.database.AppDatabase
import com.alynva.drinks.drinks.entities.Drink
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity(), MainContract.View, DrinksListFragment.OnFragmentInteractionListener {

    private val presenter : MainContract.Presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.onLoadList(this)
    }

    override fun showList(list: List<Drink>) {
        Log.d("main", "Fragment list iniciado")

        val fragmentDrinksList = DrinksListFragment.newInstance(list as ArrayList<Drink>)

        supportFragmentManager.beginTransaction()
                .replace(R.id.fmMaster, fragmentDrinksList)
                .commit()


    }

    override fun onFragmentInteraction(idDrink: Int) {

        showLoader()

        Log.d("main", "onFragmentInteraction")
        doAsync {
            val drinkDao = AppDatabase.getInstance(this@MainActivity).drinkDao()
            val drink = drinkDao.getDrink(idDrink)
            if (drink.strCategory == null) {
                Log.d("main -> presenter", "onUpdateDetails")
                presenter.onUpdateDetails(this@MainActivity, idDrink)
            } else {
                Log.d("main -> presenter", "onLoadDetails")
                presenter.onLoadDetails(this@MainActivity, drink.idDrink)
            }
        }

    }

    override fun saveDrink(drink: Drink) {
        Log.d("main", "Drink quer ser salvo")
        showLoader()
        doAsync {
            val drinkDao = AppDatabase.getInstance(this@MainActivity).drinkDao()
            drinkDao.insert(drink)
            Log.d("main", "Drink salvo")

            uiThread {
                hideLoader()
                presenter.onLoadDetails(this@MainActivity, drink.idDrink)
            }
        }
    }

    override fun showDetails(drink: Drink) {
        Log.d("main", "Fragment details iniciado")
        val fragmentDetail = DrinksDetailFragment.newInstance(drink)

        supportFragmentManager.beginTransaction()
                .replace(R.id.fmMaster, fragmentDetail)
                .addToBackStack(null)
                .commit()
    }

    override fun showLoader() {
        pb_loader.visibility = ProgressBar.VISIBLE
    }

    override fun hideLoader() {
        pb_loader.visibility = ProgressBar.INVISIBLE
    }
    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_random -> {
                presenter.onLoadRandom(this)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
