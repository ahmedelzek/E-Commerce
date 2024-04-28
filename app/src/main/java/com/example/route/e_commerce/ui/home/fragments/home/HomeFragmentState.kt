package com.example.route.e_commerce.ui.home.fragments.home

import com.example.route.e_commerce.data.models.category.Category
import com.example.route.e_commerce.data.models.product.Product


sealed class HomeFragmentState {
    class CategoriesLoaded(val categoriesList: List<Category?>) : HomeFragmentState()
    class ProductsLoaded(val productsList: List<Product?>) : HomeFragmentState()
    class MostSellingLoaded(val mostSellingList: List<Product?>) : HomeFragmentState()
    class CategoryClicked(val category: Category, val position: Int) : HomeFragmentState()
}