package com.ragabz.picsum.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class DataBindingFragment<DB : ViewDataBinding>(
    @LayoutRes val contentId: Int
) : Fragment() {

    private var _binding: DB? = null
    protected val binding: DB
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(layoutInflater, contentId, container, false)
        onInitBinding()
        return binding.root
    }

    @CallSuper
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    abstract fun onInitBinding()
}
