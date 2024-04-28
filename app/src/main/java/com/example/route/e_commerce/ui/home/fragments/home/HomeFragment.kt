package com.example.route.e_commerce.ui.home.fragments.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.route.e_commerce.R
import com.example.route.e_commerce.base.BaseFragment
import com.example.route.e_commerce.data.models.category.Category
import com.example.route.e_commerce.data.models.product.Product
import com.example.route.e_commerce.databinding.FragmentHomeBinding
import com.example.route.e_commerce.ui.home.fragments.home.adapters.CategoriesRecyclerAdapter
import com.example.route.e_commerce.ui.home.fragments.home.adapters.ProductsRecyclerAdapter
import com.example.route.e_commerce.ui.utils.UIConstants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: HomeViewModel by viewModels()
    private var mostSellingAdapter = ProductsRecyclerAdapter(null)
    private var categoriesAdapter = CategoriesRecyclerAdapter(null)
    private var productsAdapter = ProductsRecyclerAdapter(null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        renderUi()
        initOffersRecyclerView()
        initCategoriesRecyclerView()
        initProductsRecyclerView()
    }

    private fun renderUi() {
        viewModel.state.observe(viewLifecycleOwner) { state ->
            when (state) {
                is HomeFragmentState.CategoriesLoaded -> bindCategories(state.categoriesList)
                is HomeFragmentState.ProductsLoaded -> bindProducts(state.productsList)
                is HomeFragmentState.MostSellingLoaded -> bindMostSellingProducts(state.mostSellingList)
                is HomeFragmentState.CategoryClicked -> navigateToCategoriesScreen(
                    state.category,
                    state.position
                )
            }
        }
    }

    private fun navigateToCategoriesScreen(category: Category, position: Int) {
        val preLoadedData = Bundle().apply {
            val arrayList = ArrayList(categoriesAdapter.categoriesList!!)
            putParcelableArrayList(UIConstants.PASSED_CATEGORIES_LIST, arrayList)
            putParcelable(UIConstants.PASSED_CATEGORY, category)
            putInt(UIConstants.PASSED_POSITION, position)
        }
        findNavController().navigate(R.id.action_homeFragment_to_categoriesFragment, preLoadedData)
    }

    override fun getLayoutId(): Int = R.layout.fragment_home

    private fun bindCategories(categoriesList: List<Category?>?) {
        if (categoriesList.isNullOrEmpty()) return
        // TODO: loading is delayed for debug purposes only, this MUST be removed from release versions
        Handler(Looper.getMainLooper()).postDelayed({
            binding.categoriesShimmerViewContainer.stopShimmer()
            categoriesAdapter.categoriesList = categoriesList
            categoriesAdapter.notifyDataSetChanged()
        }, 1000)
    }

    private fun bindProducts(productsList: List<Product?>?) {
        if (productsList.isNullOrEmpty()) return
        // TODO: loading is delayed for debug purposes only, this MUST be removed from release versions
        Handler(Looper.getMainLooper()).postDelayed({
            binding.categoryProductsShimmerViewContainer.stopShimmer()
            productsAdapter.productsList = productsList
            productsAdapter.notifyDataSetChanged()
        }, 1000)
    }

    private fun bindMostSellingProducts(mostSellingList: List<Product?>?) {
        if (mostSellingList.isNullOrEmpty()) return
        // TODO: loading is delayed for debug purposes only, this MUST be removed from release versions
        Handler(Looper.getMainLooper()).postDelayed({
            binding.mostSellingProductsShimmerViewContainer.stopShimmer()
            mostSellingAdapter.productsList = mostSellingList
            mostSellingAdapter.notifyDataSetChanged()
        }, 1000)
    }

    private fun initProductsRecyclerView() {
        binding.categoryProductsRv.adapter = productsAdapter
        viewModel.invoke(HomeFragmentAction.GetProducts(UIConstants.WOMEN_FASHION_CATEGORY_ID))
    }

    private fun initOffersRecyclerView() {
        binding.mostSellingProductsRv.adapter = mostSellingAdapter
        viewModel.invoke(HomeFragmentAction.GetProducts(UIConstants.WOMEN_FASHION_CATEGORY_ID))
    }


    private fun initCategoriesRecyclerView() {
        categoriesAdapter.setOnCategoryClickListener { category, position ->
            viewModel.invoke(HomeFragmentAction.CategoryClicked(category, position))
        }
        binding.categoriesRv.adapter = categoriesAdapter
        viewModel.invoke(HomeFragmentAction.GetAllCategories)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.categoryProductsShimmerViewContainer.stopShimmer()
        binding.categoriesShimmerViewContainer.stopShimmer()
        binding.mostSellingProductsShimmerViewContainer.stopShimmer()
    }

}
