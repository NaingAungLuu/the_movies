package com.androboy.themovies.mvp.view

import com.androboy.themovies.data.vos.MovieVO

interface MovieSearchView : BaseView {

    fun showSearchResults(results : List<MovieVO>)

}