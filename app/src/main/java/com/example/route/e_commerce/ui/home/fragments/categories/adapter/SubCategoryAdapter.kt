package com.example.route.e_commerce.ui.home.fragments.categories.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.route.e_commerce.R
import com.example.route.e_commerce.data.models.subcategory.SubCategory
import com.example.route.e_commerce.databinding.ItemSubcategoryBinding

class SubCategoryAdapter(var subCategoriesList: List<SubCategory?>?) :
    RecyclerView.Adapter<SubCategoryAdapter.SubCategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCategoryViewHolder {
        val binding =
            ItemSubcategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SubCategoryViewHolder(binding)
    }

    override fun getItemCount() = subCategoriesList?.size ?: 0

    override fun onBindViewHolder(holder: SubCategoryViewHolder, position: Int) {
        val category = subCategoriesList!![position] ?: return
        holder.bind(category)
    }


    class SubCategoryViewHolder(private val binding: ItemSubcategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(subCategory: SubCategory?) {
            binding.subcategoryImg.setImageResource(R.drawable.image_standing_man)
            binding.subCategory = subCategory
        }
    }

}