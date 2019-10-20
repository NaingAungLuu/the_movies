package com.androboy.themovies.network.dataAgents

import com.androboy.themovies.data.vos.MovieVO

interface MovieDataAgent {

    fun getNowPlaying(apiKey : String,
                      language : String,
                      onSuccess : (List<MovieVO>) -> Unit,
                      onFailure : (msg : String ) -> Unit )

    fun getPopular(apiKey : String,
                   language : String,
                   onSuccess : (List<MovieVO>) -> Unit,
                   onFailure : (msg : String ) -> Unit )

    fun getTopRated(apiKey : String,
                    language : String,
                    onSuccess : (List<MovieVO>) -> Unit,
                    onFailure : (msg : String ) -> Unit )

    fun getUpcoming(apiKey : String,
                    language : String,
                    onSuccess : (List<MovieVO>) -> Unit,
                    onFailure : (msg : String ) -> Unit )

    fun getSimilarMovies(apiKey : String,
                         movieID : Int,
                         onSuccess : (List<MovieVO>) -> Unit,
                         onFailure : (msg : String ) -> Unit )

    fun getMovieDetails(movieID : Int,
                        apiKey : String,
                        onSuccess: (MovieVO) -> Unit,
                        onFailure: (msg: String) -> Unit)

    fun searchMovie(    apiKey : String,
                        query : String,
                        onSuccess: (List<MovieVO>) -> Unit,
                        onFailure: (msg: String) -> Unit)

}