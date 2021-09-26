package com.ragabz.movieonline.models


import com.google.gson.annotations.SerializedName

data class PaginationApiBaseResponse<T>(

    @SerializedName("id") val id: Int?,

    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: List<T>,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)


data class SearchResult(
    val page: Int,
    val results: List<MovieModel>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)