package com.example.route.e_commerce.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.route.e_commerce.R
import com.example.route.e_commerce.ui.auth.AuthActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        navigateHome()
    }

    private fun navigateHome() {
        Handler(mainLooper).postDelayed({
            startActivity(Intent(this, AuthActivity::class.java))
            finish()
        }, 2000)
    }
}