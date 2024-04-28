package com.example.route.e_commerce.domain.repos.products_repo

import com.example.route.e_commerce.data.models.product.Product

interface ProductsRepo {
    suspend fun getProducts(categoryId: String): List<Product?>

}