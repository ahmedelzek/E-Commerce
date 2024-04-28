package com.example.route.e_commerce.domain.usecases.categories

import com.example.route.e_commerce.data.models.category.Category
import com.example.route.e_commerce.domain.repos.categories_repo.CategoriesRepo
import javax.inject.Inject

class GetAllCategoriesUseCase @Inject constructor(
    private var categoriesRepository: CategoriesRepo
) {

    suspend fun execute(): List<Category?> {
        return categoriesRepository.getAllCategories()
    }
}