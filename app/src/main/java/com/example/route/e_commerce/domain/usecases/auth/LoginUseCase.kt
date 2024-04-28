package com.example.route.e_commerce.domain.usecases.auth

import com.example.route.e_commerce.domain.repos.auth_repo.AuthRepo
import javax.inject.Inject

class LoginUseCase @Inject constructor(private var authRepo: AuthRepo) {

    suspend fun execute(email: String, password: String) {
        authRepo.login(email, password)
    }
}