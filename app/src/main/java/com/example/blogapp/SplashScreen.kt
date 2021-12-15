package com.example.blogapp

import androidx.appcompat.app.AppCompatActivity
import android.view.animation.Animation
import android.os.Bundle
import android.view.WindowManager
import com.example.blogapp.R
import android.content.Intent
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.example.blogapp.MainActivity

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        val topAnim: Animation = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        val logo: ImageView = findViewById(R.id.appLogo)

        logo.startAnimation(topAnim)
        val intent = Intent(this@SplashScreen, CreatePost::class.java)
        val splashScreen = 3000

        Handler().postDelayed({
            startActivity(intent)
            finish()
        }, splashScreen.toLong())
    }

}