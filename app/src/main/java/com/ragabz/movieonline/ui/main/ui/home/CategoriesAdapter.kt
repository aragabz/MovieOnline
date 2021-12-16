package com.ragabz.movieonline.ui.main.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding
import com.ragabz.movieonline.databinding.ItemCategoryBinding
import com.ragabz.picsum.base.ViewBindingHolder

class CategoriesAdapter(val listener: ItemClickListener) :
    ListAdapter<CategoryItemModel, CategoryViewHolder>(CategoryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        (holder.binding as ItemCategoryBinding).apply {
            val item = getItem(position)
            val adapter = MoviesAdapter(listener)
            recyclerView.adapter = adapter
            adapter.submitList(item.moviesList)
            textViewTitle.text = item.categoryTitle
        }
    }

    /**
     * movie diff util callback that used in list adapter
     */
    internal class CategoryDiffCallback : DiffUtil.ItemCallback<CategoryItemModel>() {
        override fun areItemsTheSame(
            oldItem: CategoryItemModel,
            newItem: CategoryItemModel
        ): Boolean {
            return oldItem.categoryTitle == newItem.categoryTitle
        }

        override fun areContentsTheSame(
            oldItem: CategoryItemModel,
            newItem: CategoryItemModel
        ): Boolean {
            return oldItem.categoryTitle == newItem.categoryTitle
        }
    }
}

class CategoryViewHolder(
    binding: ViewBinding
) : ViewBindingHolder(binding)
