package com.ragabz.movieonline.di

import com.ragabz.movieonline.data.datasource.MovieDatasource
import com.ragabz.movieonline.data.local.MovieDatabase
import com.ragabz.movieonline.data.local.MovieLocalDatasource
import com.ragabz.movieonline.data.remote.MovieApi
import com.ragabz.movieonline.data.remote.MovieRemoteDatasource
import com.ragabz.movieonline.di.qualifiers.LocalDatasource
import com.ragabz.movieonline.di.qualifiers.RemoteDatasource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {


    @Provides
    fun provideDatabase(): MovieDatabase = MovieDatabase()


    @LocalDatasource
    @Provides
    fun provideMovieLocalDatasource(movieDatabase: MovieDatabase): MovieDatasource {
        return MovieLocalDatasource()
    }

    @RemoteDatasource
    @Provides
    fun provideMovieRemoteDatasource(movieApi: MovieApi): MovieDatasource {
        return MovieRemoteDatasource(movieApi)
    }
}