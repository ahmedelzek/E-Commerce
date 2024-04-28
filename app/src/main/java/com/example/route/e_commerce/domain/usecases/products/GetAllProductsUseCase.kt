package com.example.route.e_commerce.domain.usecases.products

import com.example.route.e_commerce.data.models.product.Product
import com.example.route.e_commerce.domain.repos.products_repo.ProductsRepo
import javax.inject.Inject

class GetAllProductsUseCase @Inject constructor(
    private val productsRepository: ProductsRepo
) {
    suspend fun execute(categoryId: String): List<Product?> {
        return productsRepository.getProducts(categoryId)
    }
}