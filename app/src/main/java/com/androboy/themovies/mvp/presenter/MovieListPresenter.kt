package com.androboy.themovies.mvp.presenter

import android.app.Activity
import com.androboy.themovies.activities.BaseActivity
import com.androboy.themovies.data.model.MovieModelImpl
import com.androboy.themovies.mvp.view.MovieListView
import androidx.lifecycle.Observer

class MovieListPresenter : BasePresenter<MovieListView>() {

    private val model = MovieModelImpl



    fun onUiReady(activity : BaseActivity)
    {
        model.getNowPlaying {
            mView.showErrorMessage(it)
        }.observe(activity , Observer {
            mView.showNowComingMovies(it)
        } )

        model.getPopular{
            mView.showErrorMessage(it)
        }.observe(activity , Observer {
            mView.showPopularMovies(it)
        })

        model.getTopRated{
            mView.showErrorMessage(it)
        }.observe(activity , Observer{
            mView.showTopRatedMovies(it)
        })

        model.getUpcoming{
            mView.showErrorMessage(it)
        }.observe(activity , Observer{
            mView.showUpcomingMovies(it)
        })

    }




}