package com.ragabz.movieonline.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


data class Movie(
    @SerializedName("description") val description: String,
    @SerializedName("favorite_count") val favoriteCount: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("item_count") val itemCount: Int,
    @SerializedName("iso_639_1") val iso: String,
    @SerializedName("list_type") val listType: String,
    @SerializedName("name") val name: String,
    @SerializedName("poster_path") val posterPath: String
)

@Entity
data class MovieEntity(
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "favorite_count") val favoriteCount: Int,

    @PrimaryKey @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "item_count")
    val itemCount: Int,
    @ColumnInfo(name = "iso_639_1")
    val iso: String,
    @ColumnInfo(name = "list_type")
    val listType: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "poster_path")
    val posterPath: String
)