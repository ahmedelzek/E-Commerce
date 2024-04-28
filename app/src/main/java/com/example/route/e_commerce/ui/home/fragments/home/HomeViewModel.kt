package com.example.route.e_commerce.ui.home.fragments.home


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.route.e_commerce.base.BaseViewModel
import com.example.route.e_commerce.data.models.category.Category
import com.example.route.e_commerce.domain.usecases.categories.GetAllCategoriesUseCase
import com.example.route.e_commerce.domain.usecases.products.GetAllProductsUseCase
import com.example.route.e_commerce.ui.model.ViewMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase,
    private val getProductsUseCase: GetAllProductsUseCase
) : BaseViewModel() {

    val state = MutableLiveData<HomeFragmentState>()

    fun invoke(action: HomeFragmentAction) {
        when (action) {
            HomeFragmentAction.GetAllCategories -> getAllCategories()
            is HomeFragmentAction.GetProducts -> getProducts(action.categoryId)
            is HomeFragmentAction.GetMostSellingProducts -> getMostSellingProducts(action.categoryId)
            is HomeFragmentAction.CategoryClicked -> categoryClick(action.category, action.position)
        }
    }

    private fun categoryClick(category: Category, position: Int) {
        state.value = HomeFragmentState.CategoryClicked(category, position)
    }

    private fun getAllCategories() {
        viewModelScope.launch {
            try {
                state.value = HomeFragmentState.CategoriesLoaded(
                    getAllCategoriesUseCase.execute()
                )
            } catch (e: Exception) {
                viewMessageLiveData.value = ViewMessage(message = e.message)
            }
        }
    }

    private fun getProducts(categoryId: String) {
        viewModelScope.launch {
            try {
                state.value = HomeFragmentState.ProductsLoaded(
                    getProductsUseCase.execute(categoryId)
                )
            } catch (e: Exception) {
                viewMessageLiveData.value = ViewMessage(message = e.message)
            }
        }
    }

    private fun getMostSellingProducts(categoryId: String) {
        viewModelScope.launch {
            try {
                state.value = HomeFragmentState.MostSellingLoaded(
                    getProductsUseCase.execute(categoryId)
                )
            } catch (e: Exception) {
                viewMessageLiveData.value = ViewMessage(message = e.message)
            }
        }
    }
}
