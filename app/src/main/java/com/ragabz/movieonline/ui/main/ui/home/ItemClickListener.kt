package com.ragabz.movieonline.ui.main.ui.home

import com.ragabz.movieonline.models.Movie

interface ItemClickListener {
    fun openMovieDetails(movie: Movie)
}
