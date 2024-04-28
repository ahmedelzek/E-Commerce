package com.example.route.e_commerce.data.data_sources.remote_datasource

import com.example.route.e_commerce.data.models.category.Category
import com.example.route.e_commerce.data.models.product.Product
import com.example.route.e_commerce.data.models.subcategory.SubCategory


interface RemoteDataSource {
    suspend fun login(email: String, password: String)
    suspend fun getAllCategories(): List<Category?>
    suspend fun getProducts(categoryId: String): List<Product?>
    suspend fun getAllSubCategories(categoryId: String): List<SubCategory?>
}