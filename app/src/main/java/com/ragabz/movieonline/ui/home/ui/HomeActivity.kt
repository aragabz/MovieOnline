package com.ragabz.movieonline.ui.home.ui

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.ragabz.movieonline.R
import com.ragabz.movieonline.base.BaseDataBindingActivity
import com.ragabz.movieonline.databinding.ActivityHomeBinding

class HomeActivity : BaseDataBindingActivity<ActivityHomeBinding, HomeViewModel>(
    R.layout.activity_home
) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
    }

}