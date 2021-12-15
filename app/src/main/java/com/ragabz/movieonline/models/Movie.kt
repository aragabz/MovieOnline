package com.ragabz.movieonline.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Movie(
    @ColumnInfo @SerializedName("description") val description: String,
    @ColumnInfo @SerializedName("favorite_count") val favoriteCount: Int,
    @PrimaryKey @ColumnInfo @SerializedName("id") val id: Int,
    @ColumnInfo @SerializedName("item_count") val itemCount: Int,
    @ColumnInfo @SerializedName("iso_639_1") val iso: String,
    @ColumnInfo @SerializedName("list_type") val listType: String,
    @ColumnInfo @SerializedName("name") val name: String,
    @ColumnInfo @SerializedName("poster_path") val posterPath: String
)
