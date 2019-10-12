package com.androboy.themovies.data.vos

import com.google.gson.annotations.SerializedName
import java.util.*

data class MovieVO(

    @SerializedName("id")
    val id : Int,

    @SerializedName("popularity")
    val popularity : Float,

    @SerializedName("vote_count")
    val voteCount : Int,

    @SerializedName("video")
    val video : Boolean,

    @SerializedName("poster_path")
    val posterPath : String,

    @SerializedName("adult")
    val adult : Boolean,

    @SerializedName("backdrop_path")
    val backDropPath : String,

    @SerializedName("original_language")
    val originalLanguage : String,

    @SerializedName("original_title")
    val originalTitle : String,

    @SerializedName("genre_ids")
    val genreIDs : List<Int>,

    @SerializedName("title")
    val title : String,

    @SerializedName("vote_average")
    val voteAverage : Float,

    @SerializedName("overview")
    val overview : String,

    @SerializedName("release_date")
    val releasedDate : Date

) {
}