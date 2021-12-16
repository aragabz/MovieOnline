package com.ragabz.movieonline.ui.main.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ragabz.movieonline.data.repositories.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _categoriesList = MutableStateFlow(emptyList<CategoryItemModel>())

    val categpriesList: StateFlow<List<CategoryItemModel>> = _categoriesList

    fun getOnlineMoviesList() {
        viewModelScope.launch {
            movieRepository.fetchMoviesListAndSaveToDatabase().collect {
                // render movies list to ui
                if (it) {
                    Timber.i("success will fetch from db")
                    getCachedMoviesList()
                }
                // save time of online fetching movielist
            }
        }
    }

    fun getCachedMoviesList() {
        viewModelScope.launch {
            with(movieRepository) {
                getCachedGenres().collect { genreList ->
                    val categoriesList = mutableListOf<CategoryItemModel>()
                    getCachedMovieList().collect { movieList ->
                        genreList.forEach { genreItem ->
                            val filteredMoviesList =
                                movieList.filter { it.genreIds.contains(genreItem.id) }
                            if (filteredMoviesList.isNotEmpty()) {
                                categoriesList.add(
                                    CategoryItemModel(
                                        genreItem.name,
                                        filteredMoviesList
                                    )
                                )
                            }
                        }
                        _categoriesList.value = categoriesList
                    }
                }
            }
        }
    }

    fun deleteAllGenreAndMovies() {
        viewModelScope.launch {
            movieRepository.deleteAllGenresAndMovies().collect()
        }
    }
}
