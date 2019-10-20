package com.androboy.themovies.views.holders

import android.view.View
import coil.api.load
import coil.transform.BlurTransformation
import com.androboy.themovies.data.vos.MovieVO
import com.androboy.themovies.delegates.MovieItemDelegate
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieItemViewHolder(itemView : View , delegate : MovieItemDelegate) : BaseViewHolder<MovieVO>(itemView) {


    init {
            itemView.cvMovieItem.setOnClickListener {
                val movieID  = data?.id
                if(movieID != null) {
                    delegate.onTapMovieItem(movieID)
                }
            }
    }


    override fun bindData(data: MovieVO) {
        itemView.ivPoster.load("http://image.tmdb.org/t/p/w300/${data.posterPath}"){
            this.crossfade(true)
        }
        println("http://image.tmdb.org/t/p/w300/${data.posterPath}")
    }
}