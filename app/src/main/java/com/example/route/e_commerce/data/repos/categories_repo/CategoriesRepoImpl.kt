package com.example.route.e_commerce.data.repos.categories_repo;

import com.example.route.e_commerce.data.data_sources.remote_datasource.RemoteDataSource
import com.example.route.e_commerce.data.models.category.Category
import com.example.route.e_commerce.domain.repos.categories_repo.CategoriesRepo
import javax.inject.Inject

class CategoriesRepoImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : CategoriesRepo {
    override suspend fun getAllCategories(): List<Category?> {
        return remoteDataSource.getAllCategories()
    }
}

