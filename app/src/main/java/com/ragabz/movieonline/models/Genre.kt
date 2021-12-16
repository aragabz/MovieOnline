package com.ragabz.movieonline.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

typealias GenreList = List<Genre>
@Parcelize
@Entity
data class Genre(
    @SerializedName("id")
    @PrimaryKey @ColumnInfo val id: Int,
    @SerializedName("name")
    @ColumnInfo val name: String
): Parcelable
