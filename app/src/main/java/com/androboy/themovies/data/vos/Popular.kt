package com.androboy.themovies.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "popular_movies" , indices = [Index(value = ["movie_id" , "id"] , unique =  true)])
class Popular (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val popularPk : Int,


    @ColumnInfo(name = "movie_id")
    val movieID : Int
) {
}