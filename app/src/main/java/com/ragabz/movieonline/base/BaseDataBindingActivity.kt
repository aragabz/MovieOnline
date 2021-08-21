package com.ragabz.movieonline.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

open class BaseDataBindingActivity<DB : ViewDataBinding, VM: BaseViewModel>(
    @LayoutRes val layoutId: Int
) : AppCompatActivity() {

    lateinit var binding: DB
    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
    }

}