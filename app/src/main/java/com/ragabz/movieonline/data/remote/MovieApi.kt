package com.ragabz.movieonline.data.remote

import com.ragabz.movieonline.models.*
import retrofit2.Call
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

const val ENDPOINT_MOVIES_LIST = "${MOVIE_ENDPOINT}/lists"
const val ENDPOINT_RECOMMENDATIONS_LIST = "${MOVIE_ENDPOINT}/recommendations"
const val ENDPOINT_MOVIE_VIDEOS_LIST = "${MOVIE_ENDPOINT}/videos"
const val ENDPOINT_MOVIE_SEARCH= "search/movie"

interface MovieApi {

    /**
     * Get List of Movies
     */
    @GET(ENDPOINT_MOVIES_LIST)
    fun fetchMoviesList(
        @Path(MOVIE_Id) id: Int,
        @Query(API_KEY) apiKey: String,
        @Query(LANGUAGE) language: String,
        @Query(PAGE) page: Int
    ): Call<PaginationApiBaseResponse<Movie>>

    @GET(ENDPOINT_RECOMMENDATIONS_LIST)
    fun fetchRecommendMovies(
        @Path(MOVIE_Id) id: Int,
        @Query(API_KEY) apiKey: String,
        @Query(LANGUAGE) language: String,
        @Query(PAGE) page: Int
    ): Call<PaginationApiBaseResponse<RecommendedMovie>>

    @GET(ENDPOINT_MOVIE_VIDEOS_LIST)
    fun fetchVideosOfMovie(
        @Path(MOVIE_Id) id: Int,
        @Query(LANGUAGE) language: String,
        @Query(API_KEY) apiKey: String
    ): Call<PaginationApiBaseResponse<Video>>

    @GET(ENDPOINT_MOVIE_SEARCH)
    fun search(
        @Query(API_KEY) apiKey: String = "cdb038aa9998174544492ddbe293dd0e",
        @Query(QUERY) query: String
    ): Call<SearchResult>

}