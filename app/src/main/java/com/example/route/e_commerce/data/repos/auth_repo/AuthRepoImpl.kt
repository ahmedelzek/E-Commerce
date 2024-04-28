package com.example.route.e_commerce.data.repos.auth_repo

import com.example.route.e_commerce.data.data_sources.remote_datasource.RemoteDataSource
import com.example.route.e_commerce.domain.repos.auth_repo.AuthRepo
import javax.inject.Inject

class AuthRepoImpl @Inject constructor(private var remoteDataSource: RemoteDataSource) : AuthRepo {
    override suspend fun login(email: String, password: String) {
        remoteDataSource.login(email, password)
    }

}