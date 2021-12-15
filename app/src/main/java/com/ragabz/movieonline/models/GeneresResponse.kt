package com.ragabz.movieonline.models


import com.google.gson.annotations.SerializedName

data class GeneresResponse(
    @SerializedName("genres")
    val genres: List<Genre>
)