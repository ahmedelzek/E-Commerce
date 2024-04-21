package com.example.route.e_commerce.data.utils

import android.content.SharedPreferences
import javax.inject.Inject

class SharedPreferencesHelper @Inject constructor(private val sharedPreferences: SharedPreferences) {
    fun saveToken(token: String) {
        with(sharedPreferences.edit()) {
            putString("token", token)
            apply()
        }
    }

    fun getToken(): String? {
        return sharedPreferences.getString("token", null)
    }
}
