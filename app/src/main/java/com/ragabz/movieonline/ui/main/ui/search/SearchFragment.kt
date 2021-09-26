package com.ragabz.movieonline.ui.main.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ragabz.movieonline.data.remote.MovieRemoteDatasource
import com.ragabz.movieonline.databinding.FragmentSearchBinding
import com.ragabz.movieonline.extensions.showToast
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SearchFragment : Fragment() {

    val searchViewModel: SearchViewModel by viewModels()

    lateinit var searchAdapter: SearchAdapter

    private var _binding: FragmentSearchBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root
        searchAdapter = SearchAdapter()
        binding.recyclerView.adapter = searchAdapter
        initObserver()
        return root
    }

    override fun onStart() {
        super.onStart()
        searchViewModel.startSearch("spider man")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun initObserver() {
        searchViewModel.searchResult.observe(viewLifecycleOwner) {
            it?.let { searchResult ->
                val movieList = searchResult.results
                searchAdapter.submitList(movieList)
            }?: run {
                showToast("no items found")
            }
        }

        searchViewModel.error.observe(viewLifecycleOwner) {
            showToast(it)
        }
    }


}