package com.ragabz.movieonline.utils

import com.ragabz.movieonline.data.local.MovieDatabase

object DataBaseUtils {

    fun getDataBase(): MovieDatabase {

        return MovieDatabase()
    }
}