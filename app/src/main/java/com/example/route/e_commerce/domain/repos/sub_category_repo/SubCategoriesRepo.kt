package com.example.route.e_commerce.domain.repos.sub_category_repo

import com.example.route.e_commerce.data.models.subcategory.SubCategory

interface SubCategoriesRepo {
    suspend fun getAllSubCategories(categoryId: String): List<SubCategory?>
}