package com.androboy.themovies.data.model

import com.androboy.themovies.data.vos.MovieVO
import com.androboy.themovies.utils.API_KEY
import com.androboy.themovies.utils.LANGUAGE

object MovieModelImpl : BaseModel() ,MovieModel {

    override fun getNowPlaying(
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (msg: String) -> Unit
    ) {
            dataAgent.getNowPlaying(API_KEY , LANGUAGE , { movies ->

                onSuccess(movies)

            }, {msg ->

                onFailure(msg)

            })
    }

    override fun getPopular(onSuccess: (List<MovieVO>) -> Unit,
                            onFailure: (msg: String) -> Unit) {

        dataAgent.getPopular(API_KEY , LANGUAGE , { movies ->

            onSuccess(movies)

        }, {msg ->

            onFailure(msg)

        })

    }

    override fun getTopRated(onSuccess: (List<MovieVO>) -> Unit,
                             onFailure: (msg: String) -> Unit) {

        dataAgent.getTopRated(API_KEY , LANGUAGE , { movies ->

            onSuccess(movies)

        }, {msg ->

            onFailure(msg)

        })

    }

    override fun getUpcoming(onSuccess: (List<MovieVO>) -> Unit,
                             onFailure: (msg: String) -> Unit) {

        dataAgent.getUpcoming(API_KEY , LANGUAGE , { movies ->

            onSuccess(movies)

        }, {msg ->

            onFailure(msg)

        })

    }

    override fun getSimilarMovies(onSuccess: (List<MovieVO>) -> Unit,
                                  onFailure: (msg: String) -> Unit
    ) {

    }

    override fun searchMovie(onSuccess: (List<MovieVO>) -> Unit,
                             onFailure: (msg: String) -> Unit) {

    }


}