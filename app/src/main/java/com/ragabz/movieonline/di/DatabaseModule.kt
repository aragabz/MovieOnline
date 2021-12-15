package com.ragabz.movieonline.di

import android.content.Context
import com.ragabz.movieonline.data.local.daos.MovieDao
import com.ragabz.movieonline.data.local.db.MovieOnlineDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context): MovieOnlineDatabase {
        return MovieOnlineDatabase.getDataBase(context)
    }

    @Provides
    @Singleton
    fun provideMovieDao(db: MovieOnlineDatabase): MovieDao = db.movieDao()
}
