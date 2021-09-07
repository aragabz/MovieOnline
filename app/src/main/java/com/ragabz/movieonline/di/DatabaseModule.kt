package com.ragabz.movieonline.di

import android.content.Context
import androidx.room.Room
import com.ragabz.movieonline.data.local.daos.MovieDao
import com.ragabz.movieonline.data.local.db.MovieOnlineDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

const val DB_NAME = "movie_online_database"

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context): MovieOnlineDatabase {
        return Room.databaseBuilder(context, MovieOnlineDatabase::class.java, DB_NAME).build()
    }

    @Provides
    @Singleton
    fun provideMovieDao(db: MovieOnlineDatabase): MovieDao = db.movieDao()
}