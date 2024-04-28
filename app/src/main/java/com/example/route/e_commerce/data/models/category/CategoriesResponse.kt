package com.example.route.e_commerce.data.models.category

data class CategoriesResponse(
    val results: Int? = null,
    val metadata: Metadata? = null,
    val data: List<Category?>? = null,
)