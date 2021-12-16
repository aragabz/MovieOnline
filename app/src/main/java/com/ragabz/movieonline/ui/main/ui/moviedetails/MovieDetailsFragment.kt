package com.ragabz.movieonline.ui.main.ui.moviedetails

import androidx.navigation.fragment.navArgs
import com.ragabz.movieonline.databinding.FragmentMovieDetailsBinding
import com.ragabz.movieonline.extensions.loadImageFromUrl
import com.ragabz.movieonline.utils.baseImageUrl
import com.ragabz.picsum.base.ViewBindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailsFragment : ViewBindingFragment<FragmentMovieDetailsBinding>(
    FragmentMovieDetailsBinding::inflate
) {

    val args: MovieDetailsFragmentArgs by navArgs()

    override fun onInitBinding() {
        val movie = args.movie

        binding.apply {
            textViewTitle.text = movie.title
            textViewOverview.text = movie.overview
            imageViewPoster.loadImageFromUrl(baseImageUrl + movie.posterPath)
        }
    }
}
