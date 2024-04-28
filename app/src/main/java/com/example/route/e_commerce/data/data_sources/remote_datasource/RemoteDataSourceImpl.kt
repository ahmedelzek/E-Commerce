package com.example.route.e_commerce.data.data_sources.remote_datasource

import com.example.route.e_commerce.data.api.WebServices
import com.example.route.e_commerce.data.models.auth.LoginRequest
import com.example.route.e_commerce.data.models.category.Category
import com.example.route.e_commerce.data.models.product.Product
import com.example.route.e_commerce.data.models.subcategory.SubCategory
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

    override suspend fun getAllCategories(): List<Category?> {
        try {
            val categoriesResponse = webServices.getAllCategories()
            return categoriesResponse.data ?: emptyList()
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun getProducts(categoryId: String): List<Product?> {
        try {
            return webServices.getProducts(categoryId).data ?: emptyList()
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun getAllSubCategories(categoryId: String): List<SubCategory?> {
        try {
            return webServices.getSubCategories(categoryId).data ?: emptyList()
        } catch (e: Exception) {
            throw e
        }

    }
}