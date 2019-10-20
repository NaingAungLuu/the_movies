package com.androboy.themovies.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androboy.themovies.R
import com.androboy.themovies.data.vos.MovieVO
import com.androboy.themovies.delegates.MovieItemDelegate
import com.androboy.themovies.utils.GRID_TYPE
import com.androboy.themovies.utils.LIST_TYPE
import com.androboy.themovies.views.holders.MovieItemViewHolder



class MovieListAdapter(private val delegate : MovieItemDelegate , private val listType : Int) : BaseAdapter<MovieItemViewHolder , MovieVO>() {



    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {
        holder.data = data[position]

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {

        var view : View? = null

        if (listType == LIST_TYPE) {

            view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)

        }else if(listType == GRID_TYPE)
        {

            view = LayoutInflater.from(parent.context).inflate(R.layout.movie_grid_item , parent , false)

        }
        return MovieItemViewHolder(view!! , delegate)

    }

}