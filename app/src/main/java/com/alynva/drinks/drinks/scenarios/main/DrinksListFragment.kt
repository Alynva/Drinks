package com.alynva.drinks.drinks.scenarios.main


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast

import com.alynva.drinks.drinks.R
import com.alynva.drinks.drinks.entities.Drink
import kotlinx.android.synthetic.main.fragment_drinks_list.*

class DrinksListFragment : Fragment() {

    companion object {

        private val ARG_LIST = "arg_list"

        fun newInstance(list : ArrayList<Drink>) =
            DrinksListFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_LIST, list)
                }
            }

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_drinks_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = getDrinksList()

        activity?.let { that ->
            val adapter = DrinkAdapter(that, list)

            adapter.setOnItenClickListener { id ->
                Toast.makeText(that, "Detalhes do item $id", Toast.LENGTH_SHORT).show()
            }

            val layoutManager = LinearLayoutManager(that)

            rvDrinks.adapter = adapter
            rvDrinks.layoutManager = layoutManager
        }

    }

    fun getDrinksList() : ArrayList<Drink> {
        val list = arguments?.getSerializable(ARG_LIST) as ArrayList<Drink>?
        if (list == null) {
            throw NullPointerException("Drinks list can not be null")
        }
        return list
    }

}// Required empty public constructor
