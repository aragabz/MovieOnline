package com.ragabz.movieonline.ui.splash

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.ragabz.movieonline.base.BaseViewBindingActivity
import com.ragabz.movieonline.data.local.MovieDatabase
import com.ragabz.movieonline.data.local.daos.MovieDao
import com.ragabz.movieonline.data.local.db.MovieOnlineDatabase
import com.ragabz.movieonline.databinding.ActivitySplashBinding
import com.ragabz.movieonline.extensions.navigateToNextScreen
import com.ragabz.movieonline.models.MovieEntity
import com.ragabz.movieonline.ui.login.LoginActivity
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
                Toast.makeText(this@SplashActivity, "Navigate to next", Toast.LENGTH_SHORT).show()
                navigateToLogin()
            }
        }, 3000)
    }

    override fun onStart() {
        super.onStart()
        createDb()
    }

    fun navigateToLogin() {
        navigateToNextScreen(LoginActivity::class.java)
    }


    fun createDb() {
        // insert movie
        val movieEntity = MovieEntity(
            description = "first movie object will be saved in db",
            favoriteCount = 100,
            id = 1,
            itemCount = 1000,
            iso = "nnvc",
            listType = "movies",
            name = "movie 1",
            posterPath = "/movies"
        )

        movieDao.insertMovie(movieEntity)
        // select all movies
        val moviesList = movieDao.getMovies()
        // select movie by id
        val selectedMovie = movieDao.getMovieById(1)
        // delete movie
        movieDao.deleteMovie(selectedMovie)
    }
}