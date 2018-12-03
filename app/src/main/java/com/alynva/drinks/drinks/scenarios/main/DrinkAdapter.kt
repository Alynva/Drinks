package com.alynva.drinks.drinks.scenarios.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alynva.drinks.drinks.R
import com.alynva.drinks.drinks.entities.Drink
import com.alynva.drinks.drinks.utils.GlideApp
import kotlinx.android.synthetic.main.list_drink_iten.view.*

class DrinkAdapter(val context: Context, val drinks: List<Drink>) : RecyclerView.Adapter<DrinkAdapter.ViewHolder>() {

    private var clickListener : ((id: Int) -> Unit)? = null

    override fun getItemCount(): Int {
        return drinks.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_drink_iten, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(context, drinks[position], clickListener)
    }

    fun setOnItenClickListener(click: ((id: Int) -> Unit)) {
        this.clickListener = click
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(context: Context, drink: Drink, clickListener: ((id: Int) -> Unit)?) {
            itemView.tv_drink_id.text = "#${drink.idDrink}"
            itemView.tv_drink_nome.text = drink.strDrink

            GlideApp.with(context)
                    .load(drink.strDrinkThumb)
                    .centerCrop()
                    .into(itemView.iv_drink_img)

            if (clickListener != null) {
                itemView.setOnClickListener {
                    clickListener.invoke(drink.idDrink)
                }
            }
        }
    }
}