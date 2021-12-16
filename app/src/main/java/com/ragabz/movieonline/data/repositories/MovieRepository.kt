package com.ragabz.movieonline.data.repositories

import com.ragabz.movieonline.data.local.daos.MovieDao
import com.ragabz.movieonline.data.local.prefs.DataManager
import com.ragabz.movieonline.data.remote.MovieApi
import com.ragabz.movieonline.di.ContextProviders
import com.ragabz.movieonline.models.*
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import org.threeten.bp.LocalDateTime
import timber.log.Timber
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieApi: MovieApi,
    private val movieDao: MovieDao,
    private val dataManager: DataManager,
    private val contextProviders: ContextProviders
) {

    suspend fun fetchMoviesListAndSaveToDatabase(): Flow<Boolean> {
        return flow {
            try {
                val response = movieApi.fetchMoviesList()
                if (response.isSuccessful) {
                    // save list to database
                    val appResponse = response.body() as AppResponse<Movie>
                    // select list from database

                    val genereResponse = movieApi.fetchGenreList()
                    val genereList = genereResponse.body() as GeneresResponse
                    coroutineScope {
                        movieDao.insertAllMovies(*(appResponse.results).toTypedArray())
                        movieDao.insertAllGenres(*(genereList.genres).toTypedArray())
                        val now = LocalDateTime.now().toString()
                        Timber.i("localdatetime: $now")
                        dataManager.lastSyncTime = now
                        emit(true)
                    }
                }
            } catch (exception: Exception) {
                Timber.e(exception)
                emit(false)
            }
        }
    }

    suspend fun getCachedMovieList(): Flow<MovieList> {
        return flowOf(movieDao.selectAllMovies()).flowOn(contextProviders.IO)
    }

    suspend fun getCachedGenres(): Flow<GenreList> {
        return flowOf(movieDao.selectAllGenres()).flowOn(contextProviders.IO)
    }


    suspend fun deleteAllGenresAndMovies():Flow<Unit> {
        return flow<Unit> {
            movieDao.deleteAllMovieList()
            movieDao.deleteAllGenereList()
        }.flowOn(contextProviders.IO)
    }
}
