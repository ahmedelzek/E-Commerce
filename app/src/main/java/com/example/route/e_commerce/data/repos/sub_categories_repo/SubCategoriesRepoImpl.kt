package com.example.route.e_commerce.data.repos.sub_categories_repo

import com.example.route.e_commerce.data.data_sources.remote_datasource.RemoteDataSource
import com.example.route.e_commerce.data.models.subcategory.SubCategory
import com.example.route.e_commerce.domain.repos.sub_category_repo.SubCategoriesRepo
import javax.inject.Inject

class SubCategoriesRepoImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    SubCategoriesRepo {
    override suspend fun getAllSubCategories(categoryId: String): List<SubCategory?> {
        return remoteDataSource.getAllSubCategories(categoryId)
    }
}