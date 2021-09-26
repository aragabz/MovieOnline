package com.ragabz.movieonline.ui.splash

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.ragabz.movieonline.base.BaseViewBindingActivity
import com.ragabz.movieonline.data.local.daos.MovieDao
import com.ragabz.movieonline.databinding.ActivitySplashBinding
import com.ragabz.movieonline.extensions.navigateToNextScreen
import com.ragabz.movieonline.ui.main.ui.MainActivity
import javax.inject.Inject

class SplashActivity : BaseViewBindingActivity<ActivitySplashBinding, SplashViewModel>(
    ActivitySplashBinding::inflate
) {

    @Inject
    lateinit var movieDao: MovieDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SplashViewModel::class.java)
        Handler().postDelayed(object : Runnable {
            override fun run() {
                navigateToNextScreen(MainActivity::class.java)
            }
        }, 3000)
    }
}