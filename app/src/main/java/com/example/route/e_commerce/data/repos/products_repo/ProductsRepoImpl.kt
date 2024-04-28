package com.example.route.e_commerce.data.repos.products_repo

import com.example.route.e_commerce.data.data_sources.remote_datasource.RemoteDataSource
import com.example.route.e_commerce.data.models.product.Product
import com.example.route.e_commerce.domain.repos.products_repo.ProductsRepo
import javax.inject.Inject

class ProductsRepoImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    ProductsRepo {
    override suspend fun getProducts(categoryId: String): List<Product?> {
        return remoteDataSource.getProducts(categoryId)
    }
}