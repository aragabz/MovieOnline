package com.ragabz.movieonline.data.remote

import com.ragabz.movieonline.models.*
import retrofit2.Response
import retrofit2.http.GET

interface MovieApi {
    @GET("discover/movie?api_key=4f74f29e8398828045eff21d601b0723&page=1")
    suspend fun fetchMoviesList(): Response<AppResponse>

    @GET("genre/movie/list?api_key=c50f5aa4e7c95a2a553d29b81aad6dd0&language=en-US")
    suspend fun fetchGenreList(): Response<GeneresResponse>
}
