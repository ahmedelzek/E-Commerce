package com.example.route.e_commerce.ui.home.fragments.categories.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.route.e_commerce.data.models.category.Category
import com.example.route.e_commerce.databinding.ItemCategoryRectangularBinding

class CategoryAdapter(var categoriesList: List<Category?>?) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding =
            ItemCategoryRectangularBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return CategoryViewHolder(binding)
    }

    override fun getItemCount() = categoriesList?.size ?: 0

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categoriesList!![position] ?: return
        holder.bind(category)
        holder.itemView.setOnClickListener {
            onCategoryClickListener?.onCategoryClick(category, position)
        }
    }


    class CategoryViewHolder(private val binding: ItemCategoryRectangularBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category?) {
            binding.category = category
        }
    }

    private var onCategoryClickListener: OnCategoryClickListener? = null

    fun setOnCategoryClickListener(listener: OnCategoryClickListener) {
        onCategoryClickListener = listener
    }

    fun interface OnCategoryClickListener {
        fun onCategoryClick(category: Category, position: Int)
    }
}
