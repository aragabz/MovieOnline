package com.ragabz.movieonline.ui.main.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding
import com.ragabz.movieonline.databinding.ItemMovieBinding
import com.ragabz.movieonline.extensions.loadImageFromUrl
import com.ragabz.movieonline.extensions.onClick
import com.ragabz.movieonline.models.Movie
import com.ragabz.movieonline.utils.baseImageUrl
import com.ragabz.picsum.base.ViewBindingHolder

class MoviesAdapter(val listener: ItemClickListener) :
    ListAdapter<Movie, MovieViewHolder>(MovieDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.binding.apply {
            val item = getItem(position)
            (this as ItemMovieBinding).imageView.loadImageFromUrl(baseImageUrl + item.posterPath)
            root.onClick {
                listener.openMovieDetails(item)
            }
        }
    }

    /**
     * movie diff util callback that used in list adapter
     */
    internal class MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(
            oldItem: Movie,
            newItem: Movie
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Movie,
            newItem: Movie
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }
}

class MovieViewHolder(
    binding: ViewBinding
) : ViewBindingHolder(binding)
