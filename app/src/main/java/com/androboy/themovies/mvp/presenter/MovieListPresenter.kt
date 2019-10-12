package com.androboy.themovies.mvp.presenter

import com.androboy.themovies.data.model.MovieModelImpl
import com.androboy.themovies.mvp.view.MovieListView

class MovieListPresenter : BasePresenter<MovieListView>() {

    private val model = MovieModelImpl

    override fun onCreate()
    {
        model.getNowPlaying(onSuccess = {

            mView.showNowComingMovies(it)
            mView.toggleProgressBar()

        },onFailure = {

            mView.showErrorMessage(it)

        })

        model.getPopular(onSuccess = {

            mView.showPopularMovies(it)
            mView.toggleProgressBar()

        },onFailure = {

            mView.showErrorMessage(it)

        })

        model.getTopRated(onSuccess = {

            mView.showTopRatedMovies(it)
            mView.toggleProgressBar()

        },onFailure = {

            mView.showErrorMessage(it)

        })

        model.getUpcoming(onSuccess = {

            mView.showUpcomingMovies(it)
            mView.toggleProgressBar()

        },onFailure = {

            mView.showErrorMessage(it)

        })

    }




}