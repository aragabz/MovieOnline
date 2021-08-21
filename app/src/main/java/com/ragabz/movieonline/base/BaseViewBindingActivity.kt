package com.ragabz.movieonline.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding



abstract class BaseViewBindingActivity<VB: ViewBinding, VM: BaseViewModel>(
    val bindingInflater: (LayoutInflater) -> VB
) : AppCompatActivity() {

    lateinit var binding: VB
    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindingInflater.invoke(layoutInflater)
        setContentView(binding.root)
    }
}