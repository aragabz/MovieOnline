package com.ragabz.movieonline.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Genre(
    @SerializedName("id")
    @PrimaryKey @ColumnInfo val id: Int,
    @SerializedName("name")
    @ColumnInfo val name: String
)
