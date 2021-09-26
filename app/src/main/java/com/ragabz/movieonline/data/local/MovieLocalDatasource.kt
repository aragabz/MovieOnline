package com.ragabz.movieonline.data.local

import com.ragabz.movieonline.data.datasource.MovieDatasource
import com.ragabz.movieonline.data.local.daos.MovieDao
import com.ragabz.movieonline.models.Movie
import com.ragabz.movieonline.models.RecommendedMovie
import com.ragabz.movieonline.models.SearchResult
import com.ragabz.movieonline.models.Video
import retrofit2.Call
import javax.inject.Inject

class MovieLocalDatasource @Inject constructor(private val movieDao: MovieDao) : MovieDatasource {

    override fun getMoviesList(): List<Movie> {
        TODO("Not yet implemented")
    }

    override fun getRecommendedList(): List<RecommendedMovie> {
        TODO("Not yet implemented")
    }

    override fun getVideosList(): List<Video> {
        TODO("Not yet implemented")
    }

    override fun search(searchQuery: String): Call<SearchResult> {
        TODO("Not yet implemented")
    }
}

class MovieDatabase

