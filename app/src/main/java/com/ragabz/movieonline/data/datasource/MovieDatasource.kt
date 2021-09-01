package com.ragabz.movieonline.data.datasource

import com.ragabz.movieonline.models.Movie
import com.ragabz.movieonline.models.RecommendedMovie
import com.ragabz.movieonline.models.Video

/**
 * for Movies
 */
interface MovieDatasource {

    fun getMoviesList(): List<Movie>
    fun getRecommendedList(): List<RecommendedMovie>
    fun getVideosList(): List<Video>
}