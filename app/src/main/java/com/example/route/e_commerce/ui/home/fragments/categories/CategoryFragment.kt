package com.example.route.e_commerce.ui.home.fragments.categories

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.viewModels
import com.example.route.e_commerce.R
import com.example.route.e_commerce.base.BaseFragment
import com.example.route.e_commerce.data.models.category.Category
import com.example.route.e_commerce.data.models.subcategory.SubCategory
import com.example.route.e_commerce.databinding.FragmentCategoryBinding
import com.example.route.e_commerce.ui.home.fragments.categories.adapter.CategoryAdapter
import com.example.route.e_commerce.ui.home.fragments.categories.adapter.SubCategoryAdapter
import com.example.route.e_commerce.ui.utils.UIConstants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryFragment : BaseFragment<FragmentCategoryBinding>() {

    private val viewModel: CategoryViewModel by viewModels()

    private var categoriesAdapter = CategoryAdapter(null)
    private var subCategoriesAdapter = SubCategoryAdapter(null)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        renderUi()
        initRecyclerViewAdapter()
    }

    private fun renderUi() {
        viewModel.state.observe(viewLifecycleOwner) { state ->
            when (state) {
                is CategoryFragmentState.CategoriesLoaded -> bindCategory(state.categoriesList)
                is CategoryFragmentState.SubCategoriesLoaded -> bindSubCategory(state.subCategoriesList)
                is CategoryFragmentState.CategoryClicked -> categoryClicked(
                    state.category,
                    state.position
                )
            }
        }
    }

    private fun bindCategory(categoriesList: List<Category?>?) {
        if (categoriesList.isNullOrEmpty()) return
        // TODO: loading is delayed for debug purposes only, this MUST be removed from release versions
        Handler(Looper.getMainLooper()).postDelayed({
            binding.categoriesShimmerViewContainer.stopShimmer()
            binding.categoriesShimmerViewContainer.visibility = View.INVISIBLE
            categoriesAdapter.categoriesList = categoriesList
            categoriesAdapter.notifyDataSetChanged()
        }, 1000)
    }

    private fun bindSubCategory(subCategoriesList: List<SubCategory?>?) {
        if (subCategoriesList.isNullOrEmpty()) return
        subCategoriesAdapter.subCategoriesList = subCategoriesList
        subCategoriesAdapter.notifyDataSetChanged()
    }

    private fun initRecyclerViewAdapter() {
        viewModel.invoke(CategoryFragmentAction.GetAllCategories)
        viewModel.invoke(CategoryFragmentAction.GetSubCategories(UIConstants.PASSED_CATEGORY))
        binding.subcategoryRv.adapter = subCategoriesAdapter
        binding.categoriesRv.adapter = categoriesAdapter
    }

    private fun categoryClicked(category: Category, position: Int) {
        categoriesAdapter.setOnCategoryClickListener { cate, pos ->
            viewModel.invoke(CategoryFragmentAction.CategoryClicked(cate, pos))
            viewModel.invoke(CategoryFragmentAction.GetSubCategories(cate.id.toString()))
        }
        viewModel.invoke(CategoryFragmentAction.CategoryClicked(category, position))
        viewModel.invoke(CategoryFragmentAction.GetSubCategories(category.id.toString()))
    }

    override fun getLayoutId(): Int = R.layout.fragment_category

}