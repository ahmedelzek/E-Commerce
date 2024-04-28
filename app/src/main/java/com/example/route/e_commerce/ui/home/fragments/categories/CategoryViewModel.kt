package com.example.route.e_commerce.ui.home.fragments.categories

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.route.e_commerce.base.BaseViewModel
import com.example.route.e_commerce.data.models.category.Category
import com.example.route.e_commerce.domain.usecases.categories.GetAllCategoriesUseCase
import com.example.route.e_commerce.domain.usecases.sub_categories.GetSubCategoriesUseCase
import com.example.route.e_commerce.ui.model.ViewMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase,
    private val getSubCategoriesUseCase: GetSubCategoriesUseCase
) : BaseViewModel() {
    val state = MutableLiveData<CategoryFragmentState>()

    fun invoke(action: CategoryFragmentAction) {
        when (action) {
            CategoryFragmentAction.GetAllCategories -> getAllCategories()
            is CategoryFragmentAction.GetSubCategories -> getSubCategories(action.categoryId)
            is CategoryFragmentAction.CategoryClicked -> categoryClick(
                action.category,
                action.position
            )
        }
    }

    private fun categoryClick(category: Category, position: Int) {
        state.value = CategoryFragmentState.CategoryClicked(category, position)
    }

    private fun getAllCategories() {
        viewModelScope.launch {
            try {
                state.value = CategoryFragmentState.CategoriesLoaded(
                    getAllCategoriesUseCase.execute()
                )
            } catch (e: Exception) {
                viewMessageLiveData.value = ViewMessage(message = e.message)
            }
        }
    }

    private fun getSubCategories(categoryId: String) {
        viewModelScope.launch {
            try {
                state.value = CategoryFragmentState.SubCategoriesLoaded(
                    getSubCategoriesUseCase.execute(categoryId)
                )
            } catch (e: Exception) {
                viewMessageLiveData.value = ViewMessage(message = e.message)
            }
        }
    }

}