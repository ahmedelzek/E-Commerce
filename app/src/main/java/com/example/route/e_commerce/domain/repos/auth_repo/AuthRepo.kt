package com.example.route.e_commerce.domain.repos.auth_repo


interface AuthRepo {
    suspend fun login(email: String, password: String)
}