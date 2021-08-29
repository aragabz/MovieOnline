package com.ragabz.movieonline.utils

import com.ragabz.movieonline.data.datasource.MovieDatasource
import com.ragabz.movieonline.data.local.MovieLocalDatasource
import com.ragabz.movieonline.data.remote.MovieRemoteDatasource
import com.ragabz.movieonline.data.remote.TMDBRemoteDatasource
import com.ragabz.movieonline.data.repositories.MovieRepository
import com.ragabz.movieonline.ui.home.ui.home.HomeViewModel

fun getHomeViewModel(movieRepository: MovieRepository): HomeViewModel {
    return HomeViewModel(movieRepository)
}

fun getMovieRepository(
    localDatasource: MovieDatasource,
    remoteDatasource: MovieDatasource,
): MovieRepository {
    return MovieRepository(localDatasource, remoteDatasource)
}

fun getMovieLocalDatasource(): MovieDatasource {
    return MovieLocalDatasource(DataBaseUtils.getDataBase())
}

fun getMovieRemoteDatasource(): MovieDatasource {
    return MovieRemoteDatasource(RetrofitUtils.getMoviesApi())
}
fun getTmdbRemoteDataSource(): MovieDatasource {
    return TMDBRemoteDatasource(RetrofitUtils.getTMDBApi())
}