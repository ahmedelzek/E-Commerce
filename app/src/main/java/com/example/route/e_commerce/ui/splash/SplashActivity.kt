package com.example.route.e_commerce.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.route.e_commerce.R
import com.example.route.e_commerce.data.utils.SharedPreferencesHelper
import com.example.route.e_commerce.ui.auth.AuthActivity
import com.example.route.e_commerce.ui.home.HomeActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var sharedPreferencesHelper: SharedPreferencesHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        navigate()
    }

    private fun navigate() {
        val token = sharedPreferencesHelper.getToken()
        if (token.isNullOrEmpty()) {
            navigateAuth()
        } else {
            navigateHome()
        }
    }

    private fun navigateAuth() {
        Handler(mainLooper).postDelayed({
            startActivity(Intent(this, AuthActivity::class.java))
            finish()
        }, 2000)
    }

    private fun navigateHome() {
        Handler(mainLooper).postDelayed({
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }, 2000)

    }
}