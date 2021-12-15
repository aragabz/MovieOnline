package com.ragabz.movieonline.data.local.daos

import androidx.room.*
import com.ragabz.movieonline.models.Movie
import com.ragabz.movieonline.models.MovieList

@Dao
interface MovieDao {

    @Query("select * from movie")
    suspend fun selectAllMovies(): MovieList

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg movieList: Movie)

    @Query("select * from movie where id=:movieId")
    fun getMovieById(movieId: Int): Movie

    @Query("DELETE FROM movie")
    fun deleteAllMovieList()
}
