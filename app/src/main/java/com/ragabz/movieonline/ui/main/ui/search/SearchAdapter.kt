package com.ragabz.movieonline.ui.main.ui.search

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ragabz.movieonline.R
import com.ragabz.movieonline.databinding.ItemSearchResultBinding
import com.ragabz.movieonline.models.MovieModel

class SearchAdapter() :
    ListAdapter<MovieModel, SearchAdapter.SearchViewHolder>(GamesDiffCallback()) {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        context = parent.context
        return SearchViewHolder(
            ItemSearchResultBinding.inflate(
                LayoutInflater.from(context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        (holder.binding as ItemSearchResultBinding).apply {
            val movie = getItem(position)
            val options = RequestOptions().placeholder(R.color.white)
                .error(R.color.light_grey)

            Glide.with(context).setDefaultRequestOptions(options)
                .load("https://image.tmdb.org/t/p/original/${movie.posterPath}")
                .into(imageView)

            progressBar.progress = 71
        }
    }

    /* diff callback*/
    internal class GamesDiffCallback : DiffUtil.ItemCallback<MovieModel>() {
        override fun areItemsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
            return oldItem.id == newItem.id
        }
    }

    class SearchViewHolder(itemview: ItemSearchResultBinding) : ViewBindingHolder(itemview)
}

open class ViewBindingHolder(val binding: ViewBinding) : RecyclerView.ViewHolder(binding.root)