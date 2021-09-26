package com.ragabz.movieonline.data.remote

import androidx.lifecycle.MutableLiveData
import com.ragabz.movieonline.data.datasource.MovieDatasource
import com.ragabz.movieonline.models.Movie
import com.ragabz.movieonline.models.RecommendedMovie
import com.ragabz.movieonline.models.SearchResult
import com.ragabz.movieonline.models.Video
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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

    override fun search(searchQuery: String): Call<SearchResult> {
       return api.search(query = searchQuery)
    }
}

