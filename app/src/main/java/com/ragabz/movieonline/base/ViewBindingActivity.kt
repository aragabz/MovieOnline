package com.ragabz.picsum.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

private typealias ActivityViewBindingInflater<VB> = (inflater: LayoutInflater) -> VB

abstract class ViewBindingActivity<VB : ViewBinding>(
    private val viewBindingInflater: ActivityViewBindingInflater<VB>
) : AppCompatActivity() {

    lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = viewBindingInflater.invoke(layoutInflater)
        setContentView(binding.root)
        onInitBinding()
    }

    abstract fun onInitBinding()
}