package com.androboy.themovies

import android.app.Application
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.androboy.themovies.data.model.MovieModel
import com.androboy.themovies.data.model.MovieModelImpl
import com.androboy.themovies.workers.GetMoviesWorker

class MovieApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        MovieModelImpl.initDatabase(applicationContext)
        getMovies()
    }

    fun getMovies()
    {
        val getMovieWorkRequest = OneTimeWorkRequest
            .Builder(GetMoviesWorker::class.java)
            .build()

        WorkManager.getInstance(applicationContext)
            .enqueue(getMovieWorkRequest)
    }
}