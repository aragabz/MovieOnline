package com.ragabz.movieonline.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ragabz.movieonline.data.local.daos.MovieDao
import com.ragabz.movieonline.models.Movie

const val DB_NAME = "movie_online_database"

@Database(entities = [Movie::class], version = 1)
@TypeConverters(IntTypeConverter::class)
abstract class MovieOnlineDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        fun getDataBase(context: Context) = Room
            .databaseBuilder(
                context,
                MovieOnlineDatabase::class.java,
                DB_NAME
            ).build()
    }
}
