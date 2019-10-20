package com.androboy.themovies.network.response

import com.androboy.themovies.data.vos.MovieVO
import com.google.gson.annotations.SerializedName

data class SearchResponse (

    @SerializedName("page")
    val pageNo : Int,

    @SerializedName("total_results")
    val totalResults : Int,

    @SerializedName("total_pages")
    val totalPages : Int,

    @SerializedName("results")
    val results : List<MovieVO>

){

}