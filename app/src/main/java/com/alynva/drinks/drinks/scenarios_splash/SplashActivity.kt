package com.alynva.drinks.drinks.scenarios_splash

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.alynva.drinks.drinks.R
import com.alynva.drinks.drinks.entities.Drink
import com.alynva.drinks.drinks.utils.GlideApp
import kotlinx.android.synthetic.main.activity_splash.*


class SplashActivity : AppCompatActivity(), SplashContract.View {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

//        GlideApp.with(this)
//                .load("https://us.123rf.com/450wm/nuttapol123rf/nuttapol123rf1503/nuttapol123rf150300262/38009601-table-top-and-blur-nature-of-background.jpg?ver=6")
//                .centerCrop()
//                .into(iv_splash_bg)
//        tv_splash_bg_text.setText("Table Top And Blur Nature of Background\nby Nuttapol Yupothong")
//
//        GlideApp.with(this)
//                .load("https://orig00.deviantart.net/0558/f/2018/168/5/2/_closed__summer_drink_ych_by_uszatyarbuz-dcagjie.gif")
//                .into(iv_splash_gif)
//        tv_splash_gif_text.setText("Summer drink YCH I\nby UszatyArbuz")
//
//        val presenter : SplashContract.Presenter = SplashPresenter(this)
//        presenter.onLoadList()
    }

    override fun saveList(drinks: List<Drink>) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Toast.makeText(this, "Lista recebida", Toast.LENGTH_LONG).show()
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

}
