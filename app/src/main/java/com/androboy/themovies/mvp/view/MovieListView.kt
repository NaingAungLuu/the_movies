package com.androboy.themovies.mvp.view

import com.androboy.themovies.data.vos.MovieVO

interface MovieListView : BaseView {

    fun showNowComingMovies(movies : List<MovieVO>)
    fun showPopularMovies(movies: List<MovieVO>)
    fun showTopRatedMovies(movies : List<MovieVO>)
    fun showUpcomingMovies(movies: List<MovieVO>)
    fun toggleProgressBar()

}