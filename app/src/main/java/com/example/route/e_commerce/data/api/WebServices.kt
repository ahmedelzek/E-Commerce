package com.example.route.e_commerce.data.api

import com.example.route.e_commerce.data.models.auth.AuthResponse
import com.example.route.e_commerce.data.models.auth.LoginRequest
import com.example.route.e_commerce.data.models.category.CategoriesResponse
import com.example.route.e_commerce.data.models.product.ProductsResponse
import com.example.route.e_commerce.data.models.subcategory.SubCategoriesResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface WebServices {
    @POST("/api/v1/auth/signin")
    suspend fun login(@Body loginRequest: LoginRequest): AuthResponse

    @GET("/api/v1/categories")
    suspend fun getAllCategories(): CategoriesResponse

    @GET("/api/v1/products")
    suspend fun getProducts(
        @Query("category") categoryId: String
    ): ProductsResponse

    @GET("/api/v1/categories/{categoryId}/subcategories")
    suspend fun getSubCategories(
        @Path("categoryId") categoryId: String
    ): SubCategoriesResponse
}