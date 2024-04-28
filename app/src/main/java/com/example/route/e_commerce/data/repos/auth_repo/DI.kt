package com.example.route.e_commerce.data.repos.auth_repo

import com.example.route.e_commerce.domain.repos.auth_repo.AuthRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DI {
    @Binds
    abstract fun provideAuthRepo(authRepoImpl: AuthRepoImpl): AuthRepo
}