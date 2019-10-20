package com.androboy.themovies.workers

import android.content.Context
import androidx.work.WorkerParameters
import com.androboy.themovies.data.model.MovieModelImpl
import com.androboy.themovies.data.vos.*
import com.androboy.themovies.utils.API_KEY
import com.androboy.themovies.utils.LANGUAGE

class GetMoviesWorker(context : Context, workerParams : WorkerParameters) : BaseWorker(context, workerParams) {

    override fun doWork(): Result {
        var result = Result.failure()
        val movieDao = database.movieDao()
        val nowPlayingDao = database.nowPlayingDao()
        val popularDao = database.popularDao()
        val topRatedDao = database.TopRatedDao()
        val upComingDao = database.UpComingDao()

        dataAgent.getNowPlaying(API_KEY , LANGUAGE , { movies ->

            movieDao.insertMovies(movies)
            nowPlayingDao.clearTable()
            val nowPLayingMovieList = ArrayList<NowPlaying>()
            for(movie : MovieVO in movies)
            {
                nowPLayingMovieList.add(NowPlaying(0 , movie.id))
            }
            nowPlayingDao.insertMovies(nowPLayingMovieList)
            result  = Result.success()

        }, {

            result    = Result.failure()

        })


        /**
         *  Get Popular Movies
         */
        dataAgent.getPopular(API_KEY , LANGUAGE , { movies ->

                movieDao.insertMovies(movies)
                popularDao.clearTable()
                val popularMovieList = ArrayList<Popular>()
                for(movie : MovieVO in movies)
                {
                    popularMovieList.add(Popular(0 , movie.id))
                }
                popularDao.insertMovies(popularMovieList)
                result = Result.success()

            }, {

                result = Result.failure()

            })


        /**
         * Get Top Rated Movies
         */
        dataAgent.getTopRated(API_KEY , LANGUAGE , { movies ->

            movieDao.insertMovies(movies)
            topRatedDao.clearTable()
            val topRatedMovieList = ArrayList<TopRated>()
            for(movie : MovieVO in movies)
            {
                topRatedMovieList.add(TopRated(0 , movie.id))
            }
            topRatedDao.insertMovies(topRatedMovieList)
            result = Result.success()

        }, {

            result = Result.failure()

        })

        /**
         * Get Upcoming Movies
         */
        dataAgent.getUpcoming(API_KEY , LANGUAGE , { movies ->

            movieDao.insertMovies(movies)
            upComingDao.clearTable()
            val upComingMovieList = ArrayList<UpComing>()
            for(movie : MovieVO in movies)
            {
                upComingMovieList.add(UpComing(0 , movie.id))
            }
            upComingDao.insertMovies(upComingMovieList)
            result = Result.success()

        }, {

            result = Result.failure()

        })




        return result

    }
}