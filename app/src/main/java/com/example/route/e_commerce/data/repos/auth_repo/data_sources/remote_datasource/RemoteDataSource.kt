package com.example.route.e_commerce.data.repos.auth_repo.data_sources.remote_datasource


interface RemoteDataSource {
    suspend fun login(email: String, password: String)
}