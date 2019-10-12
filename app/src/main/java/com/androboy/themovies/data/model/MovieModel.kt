package com.androboy.themovies.data.model

import com.androboy.themovies.data.vos.MovieVO

interface MovieModel {

    /**
    Get Now Playing
    Get Popular
    Get Top Rated
    Get Upcoming
    * */

    fun getNowPlaying(
        onSuccess : (List<MovieVO>) -> Unit ,
        onFailure : (msg : String ) ->Unit)

    fun getPopular(
        onSuccess : (List<MovieVO>) -> Unit ,
        onFailure : (msg : String ) ->Unit)

    fun getTopRated(
        onSuccess : (List<MovieVO>) -> Unit ,
        onFailure : (msg : String ) ->Unit)

    fun getUpcoming(
        onSuccess : (List<MovieVO>) -> Unit ,
        onFailure : (msg : String ) ->Unit)

    fun getSimilarMovies(
        onSuccess : (List<MovieVO>) -> Unit ,
        onFailure : (msg : String ) ->Unit)

    fun searchMovie(
        onSuccess : (List<MovieVO>) -> Unit ,
        onFailure : (msg : String ) ->Unit)


}