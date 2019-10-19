package com.androboy.themovies.data.model

import android.content.Context
import com.androboy.themovies.network.dataAgents.RetrofitDataAgent
import com.androboy.themovies.persistence.MovieDatabase

abstract class BaseModel {

    protected val dataAgent = RetrofitDataAgent
    protected lateinit var movieDatabase : MovieDatabase

    fun initDatabase(context: Context)
    {
        movieDatabase = MovieDatabase.getInstance(context)
    }

}