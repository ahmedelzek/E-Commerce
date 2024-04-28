package com.example.route.e_commerce.ui.home.fragments.home

import com.example.route.e_commerce.data.models.category.Category

sealed class HomeFragmentAction {
    data object GetAllCategories : HomeFragmentAction()
    class GetProducts(val categoryId: String) : HomeFragmentAction()
    class GetMostSellingProducts(val categoryId: String) : HomeFragmentAction()
    class CategoryClicked(val category: Category, val position: Int) : HomeFragmentAction()
}