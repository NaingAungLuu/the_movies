package com.androboy.themovies.mvp.presenter

import com.androboy.themovies.data.model.MovieModelImpl
import com.androboy.themovies.mvp.view.MovieSearchView

class MovieSearchResultPresenter : BasePresenter<MovieSearchView>() {


    private val model = MovieModelImpl

    fun onTapSearch(query : String)
    {
        val searchQuery = "{$query}"
        model.searchMovie(searchQuery , {

            mView.showSearchResults(it)


        },{

            mView.showErrorMessage(it)

        })
    }

}