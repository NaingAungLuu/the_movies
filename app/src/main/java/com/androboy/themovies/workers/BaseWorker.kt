package com.androboy.themovies.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.androboy.themovies.data.model.MovieModelImpl
import com.androboy.themovies.network.dataAgents.RetrofitDataAgent
import com.androboy.themovies.persistence.MovieDatabase

abstract class BaseWorker(context: Context , workerParams: WorkerParameters) : Worker(context , workerParams) {

    protected val dataAgent = RetrofitDataAgent
    protected val database = MovieDatabase.getInstance(context)


}