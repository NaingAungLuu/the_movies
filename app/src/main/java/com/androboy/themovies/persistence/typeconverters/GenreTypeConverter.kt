package com.androboy.themovies.persistence.typeconverters

import androidx.room.TypeConverter
import com.androboy.themovies.data.vos.GenreVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GenreTypeConverter {

    @TypeConverter
    fun toJson(genre : List<Int>) : String
    {
        return Gson().toJson(genre)
    }

    @TypeConverter
    fun fromJson(json : String): List<Int>
    {
        val token = object : TypeToken<List<Int>>(){}.type
        return Gson().fromJson(json , token)
    }

}