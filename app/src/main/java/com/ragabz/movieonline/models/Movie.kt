package com.ragabz.movieonline.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

typealias MovieList = List<Movie>

@Entity
data class Movie(
    @ColumnInfo @SerializedName("description") val description: String,
    @ColumnInfo @SerializedName("favorite_count") val favoriteCount: Int,
    @PrimaryKey @ColumnInfo @SerializedName("id") val id: Int,
    @ColumnInfo @SerializedName("item_count") val itemCount: Int,
    @ColumnInfo @SerializedName("iso_639_1") val iso: String,
    @ColumnInfo @SerializedName("list_type") val listType: String,
    @ColumnInfo @SerializedName("name") val name: String,
    @ColumnInfo @SerializedName("poster_path") val posterPath: String,
    @ColumnInfo @SerializedName("adult") val adult: Boolean,
    @ColumnInfo @SerializedName("backdrop_path") val backdropPath: String,
    @ColumnInfo @SerializedName("genre_ids") val genreIds: List<Int>,
    @ColumnInfo @SerializedName("original_language") val originalLanguage: String,
    @ColumnInfo @SerializedName("original_title") val originalTitle: String,
    @ColumnInfo @SerializedName("overview") val overview: String,
    @ColumnInfo @SerializedName("popularity") val popularity: Double,
    @ColumnInfo @SerializedName("release_date") val releaseDate: String,
    @ColumnInfo @SerializedName("title") val title: String,
    @ColumnInfo @SerializedName("video") val video: Boolean,
    @ColumnInfo @SerializedName("vote_average") val voteAverage: Double,
    @ColumnInfo @SerializedName("vote_count") val voteCount: Int
)
