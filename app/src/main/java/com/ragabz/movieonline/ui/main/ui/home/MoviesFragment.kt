package com.ragabz.movieonline.ui.main.ui.home

import androidx.fragment.app.viewModels
import com.ragabz.movieonline.databinding.FragmentHomeBinding
import com.ragabz.picsum.base.ViewBindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesFragment : ViewBindingFragment<FragmentHomeBinding>(
    FragmentHomeBinding::inflate
) {

    val moviesViewModel: MoviesViewModel by viewModels()

    override fun onInitBinding() {
    }




}
