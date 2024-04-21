package com.example.route.e_commerce.data.api

import com.example.route.e_commerce.data.models.auth.AuthResponse
import com.example.route.e_commerce.data.models.auth.LoginRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface WebServices {
    @POST("/api/v1/auth/signin")
    suspend fun login(@Body loginRequest: LoginRequest): AuthResponse
}