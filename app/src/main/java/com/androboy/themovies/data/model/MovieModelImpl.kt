package com.androboy.themovies.data.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.androboy.themovies.data.vos.*
import com.androboy.themovies.utils.API_KEY
import com.androboy.themovies.utils.LANGUAGE

object MovieModelImpl : BaseModel() ,MovieModel {

    override fun getNowPlaying(onFailure: (msg: String) -> Unit): LiveData<List<MovieVO>> {

        return Transformations.distinctUntilChanged(
            movieDatabase.nowPlayingDao().getNowPlayingMovies()
        )

    }


    override fun getPopular(onFailure : (msg : String ) ->Unit) : LiveData<List<MovieVO>> {

        return Transformations.distinctUntilChanged(
            movieDatabase.popularDao().getPopularMovies()
        )

    }

    override fun getTopRated(onFailure : (msg : String ) ->Unit) : LiveData<List<MovieVO>> {

        return Transformations.distinctUntilChanged(
            movieDatabase.TopRatedDao().getTopRatedMovies()
        )




    }

    override fun getUpcoming(onFailure : (msg : String ) ->Unit) : LiveData<List<MovieVO>> {

        return Transformations.distinctUntilChanged(
            movieDatabase.UpComingDao().getUpComingMovies()
        )



    }

    override fun getSimilarMovies(movieID : Int,
                                  onSuccess: (List<MovieVO>) -> Unit,
                                  onFailure: (msg: String) -> Unit
    ) {
        dataAgent.getSimilarMovies(API_KEY ,movieID , {

            onSuccess(it)

        } , {

                onFailure(it)

        })
    }

    override fun searchMovie(   query : String,
                                onSuccess: (List<MovieVO>) -> Unit,
                                onFailure: (msg: String) -> Unit) {

        dataAgent.searchMovie(API_KEY , query , {

            onSuccess(it)

        },{

            onFailure(it)

        })

    }

    override fun getMovieDetails(movieID : Int, onSuccess: (MovieVO) -> Unit, onFailure: (msg: String) -> Unit) {

        dataAgent.getMovieDetails(movieID , API_KEY , {

            onSuccess(it)

        },{

            onFailure(it)

        })

    }
}