package com.alynva.drinks.drinks.scenarios.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.alynva.drinks.drinks.R
import com.alynva.drinks.drinks.entities.Drink
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    private val presenter : MainContract.Presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.onUpdateList(this)
    }

    override fun showList(list: List<Drink>) {
        val adapter = DrinkAdapter(this, list)

        adapter.setOnItenClickListener { id ->
            Toast.makeText(this, "Detalhes do item $id", Toast.LENGTH_SHORT).show()
        }

        val layoutManager = LinearLayoutManager(this)

        rvDrinks.adapter = adapter
        rvDrinks.layoutManager = layoutManager
    }
}
