package com.example.route.e_commerce.ui.home.fragments.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.route.e_commerce.data.models.product.Product
import com.example.route.e_commerce.databinding.ItemProductBinding

class ProductsRecyclerAdapter(var productsList: List<Product?>?) :
    RecyclerView.Adapter<ProductsRecyclerAdapter.ProductViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun getItemCount() = productsList?.size ?: 0

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productsList!![position]
        holder.bind(product)
        // set click listener later
    }

    class ProductViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product?) {
            binding.product = product
        }
    }
}
