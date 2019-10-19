package com.androboy.themovies.persistence.typeconverters

import androidx.room.TypeConverter
import com.androboy.themovies.data.vos.MovieVO
import com.google.gson.Gson


class MovieTypeConverter {

    @TypeConverter
    fun toString(movie : MovieVO) : String
    {
        return Gson().toJson(movie)
    }

    @TypeConverter
    fun fromJson(json : String) : MovieVO
    {
        return Gson().fromJson(json , MovieVO::class.java)
    }

}