package com.example.route.e_commerce.data.repos.categories_repo

import com.example.route.e_commerce.domain.repos.categories_repo.CategoriesRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DI {

    @Binds
    abstract fun provideCategoriesRepo(
        categoriesRepositoryImpl: CategoriesRepoImpl
    ): CategoriesRepo
}
