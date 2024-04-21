package com.example.route.e_commerce.data.repos.auth_repo.data_sources.remote_datasource

import com.example.route.e_commerce.data.api.WebServices
import com.example.route.e_commerce.data.models.auth.LoginRequest
import com.example.route.e_commerce.data.utils.SharedPreferencesHelper
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val webServices: WebServices,
    private val sharedPreferencesHelper: SharedPreferencesHelper
) :
    RemoteDataSource {
    override suspend fun login(email: String, password: String) {
        try {
            val authResponse = webServices.login(LoginRequest(email, password))
            sharedPreferencesHelper.saveToken(authResponse.token!!)
        } catch (throwable: Throwable) {
            throw throwable
        }
    }
}