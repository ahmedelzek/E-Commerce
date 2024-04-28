package com.example.route.e_commerce.domain.usecases.sub_categories

import com.example.route.e_commerce.data.models.subcategory.SubCategory
import com.example.route.e_commerce.domain.repos.sub_category_repo.SubCategoriesRepo
import javax.inject.Inject

class GetSubCategoriesUseCase @Inject constructor(private val subCategoriesRepo: SubCategoriesRepo) {
    suspend fun execute(categoryId: String): List<SubCategory?> {
        return subCategoriesRepo.getAllSubCategories(categoryId)
    }
}