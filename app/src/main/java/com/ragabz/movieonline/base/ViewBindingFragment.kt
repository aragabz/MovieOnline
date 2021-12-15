package com.ragabz.picsum.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

typealias FragmentViewBindingInflater<VB> = (
    inflater: LayoutInflater,
    parent: ViewGroup?,
    attachToParent: Boolean
) -> VB

abstract class ViewBindingFragment<VB : ViewBinding>
constructor(
    private val viewBindingInflater: FragmentViewBindingInflater<VB>
) : Fragment() {

    private var _binding: VB? = null
    val binding: VB
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = viewBindingInflater.invoke(layoutInflater, container, false)
        onInitBinding()
        return binding.root
    }

    abstract fun onInitBinding()

    @CallSuper
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
