package com.ragabz.movieonline.data.remote

import com.ragabz.movieonline.models.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val BASE_URL = "https://developers.themoviedb.org/3/"
const val MOVIE_Id = "movie_id"
const val PAGE = "page"
const val QUERY = "query"
const val LANGUAGE = "language"
const val API_KEY = "api_key"
const val MOVIE_ENDPOINT = "/movie/{movie_id}"

const val ENDPOINT_MOVIES_LIST = "$MOVIE_ENDPOINT/lists"
const val ENDPOINT_RECOMMENDATIONS_LIST = "$MOVIE_ENDPOINT/recommendations"
const val ENDPOINT_MOVIE_VIDEOS_LIST = "$MOVIE_ENDPOINT/videos"
const val ENDPOINT_MOVIE_SEARCH = "search/movie"

interface MovieApi {
    @GET("discover/movie?api_key=4f74f29e8398828045eff21d601b0723&page=1")
    suspend fun fetchMoviesList(): Response<List<Movie>>
}
