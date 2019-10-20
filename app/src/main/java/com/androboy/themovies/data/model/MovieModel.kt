package com.androboy.themovies.data.model

import androidx.lifecycle.LiveData
import com.androboy.themovies.data.vos.MovieVO

interface MovieModel {

    /**
    Get Now Playing
    Get Popular
    Get Top Rated
    Get Upcoming
    * */

    fun getNowPlaying(
        onFailure : (msg : String ) ->Unit) : LiveData<List<MovieVO>>

    fun getPopular(
        onFailure : (msg : String ) ->Unit) : LiveData<List<MovieVO>>

    fun getTopRated(
        onFailure : (msg : String ) ->Unit) : LiveData<List<MovieVO>>

    fun getUpcoming(
        onFailure : (msg : String ) ->Unit) : LiveData<List<MovieVO>>

    fun getSimilarMovies(
        movieID : Int,
        onSuccess : (List<MovieVO>) -> Unit,
        onFailure : (msg : String ) ->Unit)

    fun searchMovie(
        query : String,
        onSuccess : (List<MovieVO>) -> Unit,
        onFailure : (msg : String ) ->Unit)

    fun getMovieDetails(
        movieID: Int,
        onSuccess : (MovieVO) -> Unit,
        onFailure : (msg : String ) ->Unit)

}