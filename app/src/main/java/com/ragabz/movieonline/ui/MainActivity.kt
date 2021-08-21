package com.ragabz.movieonline.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ragabz.movieonline.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        Log.i("TAG", "onResume: ")
    }

    override fun onStart() {
        super.onStart()
        Log.i("TAG", "onStart: ")
    }
}