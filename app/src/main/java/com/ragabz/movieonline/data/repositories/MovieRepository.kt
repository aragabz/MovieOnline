package com.ragabz.movieonline.data.repositories

import com.ragabz.movieonline.data.local.daos.MovieDao
import com.ragabz.movieonline.data.remote.MovieApi
import com.ragabz.movieonline.di.ContextProviders
import com.ragabz.movieonline.models.AppResponse
import com.ragabz.movieonline.models.MovieList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieApi: MovieApi,
    private val movieDao: MovieDao,
    private val contextProviders: ContextProviders
) {

    suspend fun fetchMoviesListAndSaveToDatabase(): Flow<MovieList> {
        return flow<MovieList> {
            try {
                val response = movieApi.fetchMoviesList()
                if (response.isSuccessful) {
                    // save list to database
                    val appResponse = response.body() as AppResponse
                    movieDao.insert(*(appResponse.results).toTypedArray())
                    // select list from database
                    emit(movieDao.selectAllMovies())
                }
            } catch (exception: Exception) {
                emit(emptyList())
            }
        }
    }

    suspend fun getCachedMovieList(): Flow<MovieList> {
        return flowOf(movieDao.selectAllMovies()).flowOn(contextProviders.IO)
    }

    suspend fun deleteAllMovies() {
        flow<Unit> {
            movieDao.deleteAllMovieList()
        }.flowOn(contextProviders.IO)
    }
}
