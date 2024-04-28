package com.example.route.e_commerce.ui.home.fragments.categories

import com.example.route.e_commerce.data.models.category.Category
import com.example.route.e_commerce.data.models.subcategory.SubCategory

sealed class CategoryFragmentState {
    class CategoriesLoaded(val categoriesList: List<Category?>) : CategoryFragmentState()
    class SubCategoriesLoaded(val subCategoriesList: List<SubCategory?>) : CategoryFragmentState()
    class CategoryClicked(val category: Category, val position: Int) : CategoryFragmentState()


}