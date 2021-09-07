package com.ragabz.movieonline.data.local.daos

import androidx.room.*
import com.ragabz.movieonline.models.MovieEntity


@Dao
interface MovieDao {

    @Query("select * from movieentity")
    fun getMovies(): List<MovieEntity>

    @Query("select * from movieentity where id=:movieId")
    fun getMovieById(movieId: Int): MovieEntity

    @Insert
    fun insertMovie(movie: MovieEntity)

    @Delete
    fun deleteMovie(movie: MovieEntity)

}