package com.ragabz.movieonline.di

import com.ragabz.movieonline.data.remote.BASE_URL
import com.ragabz.movieonline.data.remote.MovieApi
import com.ragabz.movieonline.data.remote.TMDBApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {


    @Provides
    fun provideHttpClient(): OkHttpClient {
       return OkHttpClient.Builder().build()
    }

    @Provides
    fun provideGson(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: GsonConverterFactory): Retrofit {

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(gson)

        return retrofitBuilder.client(okHttpClient).build()
    }


    @Provides
    @Singleton
    fun provideMovieApi(retrofit: Retrofit): MovieApi {
        return retrofit.create(MovieApi::class.java)
    }

    @Provides
    fun provideTMDBApi(retrofit: Retrofit): TMDBApi {
        return retrofit.create(TMDBApi::class.java)
    }

}