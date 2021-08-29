package com.ragabz.movieonline.utils

import com.ragabz.movieonline.data.remote.BASE_URL
import com.ragabz.movieonline.data.remote.MovieApi
import com.ragabz.movieonline.data.remote.MovieApiV4
import com.ragabz.movieonline.data.remote.TMDBApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitUtils {

    var retrofit: Retrofit

    init {
        val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
        retrofit = retrofitBuilder.client(httpClient.build()).build()
    }
    // tmdb
    fun getMoviesApi(): MovieApi {

        return retrofit.create(MovieApi::class.java)
    }
    //imdb
    fun getTMDBApi(): TMDBApi {
        return retrofit.create(TMDBApi::class.java)
    }


}