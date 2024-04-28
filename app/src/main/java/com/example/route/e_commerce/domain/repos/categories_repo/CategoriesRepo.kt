package com.example.route.e_commerce.domain.repos.categories_repo

import com.example.route.e_commerce.data.models.category.Category

interface CategoriesRepo {
    suspend fun getAllCategories(): List<Category?>

}