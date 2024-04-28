package com.example.route.e_commerce.data.repos.products_repo

import com.example.route.e_commerce.domain.repos.products_repo.ProductsRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DI {
    @Binds
    abstract fun provideCategoriesRepo(
        productsRepoImpl: ProductsRepoImpl
    ): ProductsRepo
}