package com.androboy.themovies.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "upcoming_movies" , indices = [Index(value = ["movie_id" , "id"] , unique =  true)])
class UpComing (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val upComingPK : Int,


    @ColumnInfo(name = "movie_id")
    val movieID : Int

){
}