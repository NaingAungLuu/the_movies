package com.androboy.themovies.views.holders

import android.view.View
import com.androboy.themovies.data.vos.MovieVO
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieItemViewHolder(itemView : View) : BaseViewHolder<MovieVO>(itemView) {

    override fun bindData(data: MovieVO) {
        Glide.with(itemView).load("http://image.tmdb.org/t/p/w300/${data.posterPath}").into(itemView.ivPoster)
        println("http://image.tmdb.org/t/p/w300/${data.posterPath}")
    }
}