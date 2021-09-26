package com.ragabz.movieonline.data.repositories


import com.ragabz.movieonline.data.datasource.MovieDatasource
import com.ragabz.movieonline.di.qualifiers.LocalDatasource
import com.ragabz.movieonline.di.qualifiers.RemoteDatasource
import com.ragabz.movieonline.models.SearchResult
import retrofit2.Call
import javax.inject.Inject

class MovieRepository @Inject constructor(
    @LocalDatasource val localDatasource: MovieDatasource,
    @RemoteDatasource val remoteDatasource: MovieDatasource
) {
    fun search(searchQuery: String): Call<SearchResult> {
        return remoteDatasource.search(searchQuery)
    }


}