package com.ragabz.movieonline.extensions

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Activity.navigateToNextScreen(destination: Class<*>) {
    Intent(this, destination).apply {
        startActivity(this)
        finish()
    }
}

fun Activity.showToast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}

fun Fragment.showToast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(requireContext(), message, length).show()
}
