package com.androboy.themovies.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "now_playing_movies" , indices = [Index(value = ["movie_id" , "id"] , unique =  true)])
class NowPlaying (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val nowPlayingPK : Int,


    @ColumnInfo(name = "movie_id")
    val movieID : Int

){



}