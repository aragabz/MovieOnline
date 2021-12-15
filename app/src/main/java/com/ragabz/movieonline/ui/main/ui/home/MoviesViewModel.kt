package com.ragabz.movieonline.ui.main.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ragabz.movieonline.data.repositories.MovieRepository
import com.ragabz.movieonline.models.MovieList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _moviesList: MutableStateFlow<MovieList> = MutableStateFlow(emptyList())

    val movieList: StateFlow<MovieList> = _moviesList

    fun getOnlineMoviesList() {
        viewModelScope.launch {
            movieRepository.fetchMoviesListAndSaveToDatabase().collect {
                // render movies list to ui
                _moviesList.value = it
                // save time of online fetching movielist
            }
        }
    }

    fun getCachedMoviesList() {
        viewModelScope.launch {
            movieRepository.getCachedMovieList().collect {
                // render movies list to ui
                _moviesList.value = it
            }
        }
    }
}
