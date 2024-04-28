package com.example.route.e_commerce.ui.home.fragments.categories

import com.example.route.e_commerce.data.models.category.Category


sealed class CategoryFragmentAction {
    data object GetAllCategories : CategoryFragmentAction()
    class GetSubCategories(val categoryId: String) : CategoryFragmentAction()
    class CategoryClicked(val category: Category, val position: Int) : CategoryFragmentAction()
}