package com.ragabz.movieonline.ui.main.ui.home

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.ragabz.movieonline.databinding.FragmentHomeBinding
import com.ragabz.picsum.base.ViewBindingFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MoviesFragment : ViewBindingFragment<FragmentHomeBinding>(
    FragmentHomeBinding::inflate
) {

    private val moviesViewModel: MoviesViewModel by viewModels()
    private val adapter: MoviesAdapter by lazy {
        MoviesAdapter()
    }

    override fun onInitBinding() {
        subscribeToViewModel()
        binding.recyclerView.adapter = adapter
        moviesViewModel.getOnlineMoviesList()
    }

    private fun subscribeToViewModel() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.RESUMED) {
                moviesViewModel.movieList.collectLatest {
                    adapter.submitList(it)
                }
            }
        }
    }
}
