package com.androboy.themovies.data.vos

import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

@Entity(tableName = "movies")
data class MovieVO(

    @PrimaryKey
    @ColumnInfo(name = "movie_id")
    @SerializedName("id")
    val id : Int,

    @ColumnInfo(name = "popularity")
    @SerializedName("popularity")
    val popularity : Float,

    @ColumnInfo(name = "vote_count")
    @SerializedName("vote_count")
    val voteCount : Int,

    @ColumnInfo(name = "video")
    @SerializedName("video")
    val video : Boolean,

    @ColumnInfo(name = "poster_path")
    @SerializedName("poster_path")
    val posterPath : String,

    @ColumnInfo(name = "adult")
    @SerializedName("adult")
    val adult : Boolean,

    @ColumnInfo(name = "backdrop_path")
    @SerializedName("backdrop_path")
    val backDropPath : String,

    @ColumnInfo(name = "original_language")
    @SerializedName("original_language")
    val originalLanguage : String,

    @ColumnInfo(name = "original_title")
    @SerializedName("original_title")
    val originalTitle : String,

    @ColumnInfo(name = "genre_ids")
    @SerializedName("genre_ids")
    val genreIDs : List<Int>,

    @ColumnInfo(name = "title")
    @SerializedName("title")
    val title : String,

    @ColumnInfo(name = "vote_average")
    @SerializedName("vote_average")
    val voteAverage : Float,

    @ColumnInfo(name = "overview")
    @SerializedName("overview")
    val overview : String,

    @ColumnInfo(name = "release_date")
    @SerializedName("release_date")
    val releasedDate : String,





    @ColumnInfo(name = "homepage")
    @SerializedName("homepage")
    val homePage : String?

) {
}