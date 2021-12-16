package com.ragabz.movieonline.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

typealias MovieList = List<Movie>

@Parcelize
@Entity
data class Movie(
    @ColumnInfo @SerializedName("adult")
    val adult: Boolean,
    @ColumnInfo @SerializedName("backdrop_path")
    val backdropPath: String,
    @ColumnInfo @SerializedName("genre_ids")
    val genreIds: List<Int>,
    @ColumnInfo @SerializedName("id")
    @PrimaryKey val id: Int,
    @ColumnInfo @SerializedName("original_language")
    val originalLanguage: String,
    @ColumnInfo @SerializedName("original_title")
    val originalTitle: String,
    @ColumnInfo @SerializedName("overview")
    val overview: String,
    @ColumnInfo @SerializedName("popularity")
    val popularity: Double,
    @ColumnInfo @SerializedName("poster_path")
    val posterPath: String,
    @ColumnInfo @SerializedName("release_date")
    val releaseDate: String,
    @ColumnInfo @SerializedName("title")
    val title: String,
    @ColumnInfo @SerializedName("video")
    val video: Boolean,
    @ColumnInfo @SerializedName("vote_average")
    val voteAverage: Double,
    @ColumnInfo @SerializedName("vote_count")
    val voteCount: Int
) : Parcelable
