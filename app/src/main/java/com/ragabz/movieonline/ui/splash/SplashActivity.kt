package com.ragabz.movieonline.ui.splash

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.ragabz.movieonline.base.BaseViewBindingActivity
import com.ragabz.movieonline.databinding.ActivitySplashBinding
import com.ragabz.movieonline.extensions.navigateToNextScreen
import com.ragabz.movieonline.ui.login.LoginActivity

class SplashActivity
    : BaseViewBindingActivity<ActivitySplashBinding, SplashViewModel>(
    ActivitySplashBinding::inflate
) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(SplashViewModel::class.java)

        Handler().postDelayed(object : Runnable {
            override fun run() {
                Toast.makeText(this@SplashActivity, "Navigate to next", Toast.LENGTH_SHORT).show()
                navigateToLogin()
            }
        }, 3000)
    }

    fun navigateToLogin() {
        navigateToNextScreen(LoginActivity::class.java)
    }
}