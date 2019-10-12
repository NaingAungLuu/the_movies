package com.androboy.themovies.network.response

import com.androboy.themovies.data.vos.DateVO
import com.androboy.themovies.data.vos.MovieVO
import com.google.gson.annotations.SerializedName

data class NowPlayingMovieResponse(

    @SerializedName("results")
    val results : List<MovieVO>,

    @SerializedName("page")
    val page : Int,

    @SerializedName("total_results")
    val totalResults : Int,

    @SerializedName("dates")
    val dates : DateVO,

    @SerializedName("total_pages")
    val totalPages : Int,

    @SerializedName("status_code")
    val statusCode : Int,

    @SerializedName("status_message")
    val statusMessage : String


){
    fun isResposneOk():Boolean
    {
        return (results != null && statusCode == 200)
    }
}