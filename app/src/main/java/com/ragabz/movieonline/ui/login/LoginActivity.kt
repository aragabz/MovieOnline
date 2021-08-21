package com.ragabz.movieonline.ui.login

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.ragabz.movieonline.base.BaseViewBindingActivity
import com.ragabz.movieonline.databinding.ActivityLoginBinding

class LoginActivity : BaseViewBindingActivity<ActivityLoginBinding, LoginViewModel>(
    ActivityLoginBinding::inflate
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

    }
}