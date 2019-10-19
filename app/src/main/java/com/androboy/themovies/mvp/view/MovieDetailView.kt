package com.androboy.themovies.mvp.view

import com.androboy.themovies.data.vos.MovieVO

interface MovieDetailView : BaseView {

    fun showSimilarMovies(movies: List<MovieVO>)
    fun showMovieDetails(movie : MovieVO)

}