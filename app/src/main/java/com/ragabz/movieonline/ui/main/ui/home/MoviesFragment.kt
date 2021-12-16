package com.ragabz.movieonline.ui.main.ui.home

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.ragabz.movieonline.data.local.prefs.DataManager
import com.ragabz.movieonline.databinding.FragmentMoviesBinding
import com.ragabz.movieonline.models.Movie
import com.ragabz.picsum.base.ViewBindingFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.temporal.ChronoUnit
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MoviesFragment :
    ViewBindingFragment<FragmentMoviesBinding>(
        FragmentMoviesBinding::inflate
    ),
    ItemClickListener {

    @Inject
    lateinit var dataManager: DataManager
    private val moviesViewModel: MoviesViewModel by viewModels()
    private val adapter: CategoriesAdapter by lazy {
        CategoriesAdapter(this)
    }

    override fun onInitBinding() {
        subscribeToViewModel()
        binding.recyclerView.adapter = adapter

        if (dataManager.lastSyncTime.trim().isNotEmpty()) {
            val dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME
            val date = LocalDateTime.parse(dataManager.lastSyncTime, dateTimeFormatter)
            val hours = ChronoUnit.HOURS.between(date, LocalDateTime.now())
            if (hours >= 4) {
                moviesViewModel.deleteAllGenreAndMovies()
                moviesViewModel.getOnlineMoviesList()
            } else {
                Timber.i("load from cache ")
                moviesViewModel.getCachedMoviesList()
            }
        } else {
            moviesViewModel.getCachedMoviesList()
        }
    }

    private fun subscribeToViewModel() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.RESUMED) {
                moviesViewModel.categpriesList.collectLatest {
                    adapter.submitList(it)
                }
            }
        }
    }

    override fun openMovieDetails(movie: Movie) {
        val directions = MoviesFragmentDirections.actionHomeFragmentToMovieDetailsFragment(movie)
        findNavController().navigate(directions)
    }
}
