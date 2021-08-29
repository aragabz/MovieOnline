package com.ragabz.movieonline.data.repositories

import com.ragabz.movieonline.data.datasource.MovieDatasource
import javax.inject.Inject

class MovieRepository(
    val localDatasource: MovieDatasource,
    val remoteDatasource: MovieDatasource
) {
}