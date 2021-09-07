package com.ragabz.movieonline.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ragabz.movieonline.data.local.daos.MovieDao
import com.ragabz.movieonline.models.MovieEntity

@Database(entities = [ MovieEntity::class], version = 1)
abstract class MovieOnlineDatabase: RoomDatabase() {

    abstract fun movieDao(): MovieDao


}