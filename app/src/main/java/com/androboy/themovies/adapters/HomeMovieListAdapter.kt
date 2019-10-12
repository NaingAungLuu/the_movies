package com.androboy.themovies.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.androboy.themovies.R
import com.androboy.themovies.data.vos.MovieVO
import com.androboy.themovies.views.holders.MovieItemViewHolder

class HomeMovieListAdapter : BaseAdapter<MovieItemViewHolder , MovieVO>() {

    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {
        holder.data = data[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item , parent , false )
        return MovieItemViewHolder(view)

    }

}