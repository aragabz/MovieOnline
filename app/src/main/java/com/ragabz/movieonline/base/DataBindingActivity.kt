package com.ragabz.picsum.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class DataBindingActivity<DB : ViewDataBinding>(
    @LayoutRes val contentId: Int
) : AppCompatActivity() {

    lateinit var binding: DB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, contentId)
        onInitBinding()
    }

    abstract fun onInitBinding()

}