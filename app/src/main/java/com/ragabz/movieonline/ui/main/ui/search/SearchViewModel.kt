package com.ragabz.movieonline.ui.main.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ragabz.movieonline.data.remote.MovieRemoteDatasource
import com.ragabz.movieonline.data.repositories.MovieRepository
import com.ragabz.movieonline.models.SearchResult
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    val movieRepository: MovieRepository
): ViewModel() {

    private val _searchResult = MutableLiveData<SearchResult>()
    val searchResult: LiveData<SearchResult> = _searchResult

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error


    fun startSearch(searchQuery: String) {
        movieRepository.search(searchQuery).enqueue(object : Callback<SearchResult> {
            override fun onResponse(call: Call<SearchResult>, response: Response<SearchResult>) {
                if(response.isSuccessful) {
                    val result = response.body() as SearchResult
                    _searchResult.postValue(result)
                }
            }

            override fun onFailure(call: Call<SearchResult>, t: Throwable) {
                _error.postValue(t.message ?: "error happend")
            }
        })
    }

}