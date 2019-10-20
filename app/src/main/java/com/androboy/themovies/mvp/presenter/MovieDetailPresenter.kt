package com.androboy.themovies.mvp.presenter

import com.androboy.themovies.data.model.MovieModelImpl
import com.androboy.themovies.mvp.view.MovieDetailView

class MovieDetailPresenter(private val movieID : Int) : BasePresenter<MovieDetailView>() {

    private val model = MovieModelImpl


    fun onUiReady() {

        model.getSimilarMovies(movieID , {

            mView.showSimilarMovies(it)

        },{

            mView.showErrorMessage(it)

        })

        model.getMovieDetails(movieID , {

            mView.showMovieDetails(it)

        }, {

            mView.showErrorMessage(it)

        })



    }
}