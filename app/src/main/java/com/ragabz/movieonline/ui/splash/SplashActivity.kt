package com.ragabz.movieonline.ui.splash

import android.os.Handler
import com.ragabz.movieonline.databinding.ActivitySplashBinding
import com.ragabz.movieonline.extensions.navigateToNextScreen
import com.ragabz.movieonline.ui.main.ui.MainActivity
import com.ragabz.picsum.base.ViewBindingActivity

class SplashActivity : ViewBindingActivity<ActivitySplashBinding>(
    ActivitySplashBinding::inflate
) {
    override fun onInitBinding() {
        Handler().postDelayed(
            { navigateToNextScreen(MainActivity::class.java) },
            1500
        )
    }
}
