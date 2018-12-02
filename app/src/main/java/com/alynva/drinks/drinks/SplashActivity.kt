package com.alynva.drinks.drinks

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_splash.*
import com.bumptech.glide.load.resource.bitmap.TransformationUtils.centerCrop
import com.bumptech.glide.request.RequestOptions



class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        GlideApp.with(this)
                .load("https://us.123rf.com/450wm/nuttapol123rf/nuttapol123rf1503/nuttapol123rf150300262/38009601-table-top-and-blur-nature-of-background.jpg?ver=6")
                .centerCrop()
                .into(iv_splash_bg)
        tv_splash_bg_text.setText("Table Top And Blur Nature of Background\nby Nuttapol Yupothong")

        GlideApp.with(this)
                .load("https://orig00.deviantart.net/0558/f/2018/168/5/2/_closed__summer_drink_ych_by_uszatyarbuz-dcagjie.gif")
                .into(iv_splash_gif)
        tv_splash_gif_text.setText("Summer drink YCH I\nby UszatyArbuz")
    }
}
