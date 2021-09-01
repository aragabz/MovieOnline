package com.ragabz.movieonline.data.remote

import com.ragabz.movieonline.data.datasource.MovieDatasource
import com.ragabz.movieonline.models.Movie
import com.ragabz.movieonline.models.RecommendedMovie
import com.ragabz.movieonline.models.Video
import javax.inject.Inject

class MovieRemoteDatasource @Inject constructor(
    val api: MovieApi
) : MovieDatasource {


    override fun getMoviesList(): List<Movie> {
        TODO("Not yet implemented")
    }

    override fun getRecommendedList(): List<RecommendedMovie> {
        TODO("Not yet implemented")
    }

    override fun getVideosList(): List<Video> {
        TODO("Not yet implemented")
    }
}

class TMDBRemoteDatasource(val api: TMDBApi) : MovieDatasource {
    override fun getMoviesList(): List<Movie> {
        TODO("Not yet implemented")
    }

    override fun getRecommendedList(): List<RecommendedMovie> {
        TODO("Not yet implemented")
    }

    override fun getVideosList(): List<Video> {
        TODO("Not yet implemented")
    }
}

