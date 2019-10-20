package com.androboy.themovies.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import coil.api.load
import coil.transform.BlurTransformation
import com.androboy.themovies.R
import com.androboy.themovies.activities.MainActivity
import com.androboy.themovies.adapters.MovieListAdapter
import com.androboy.themovies.data.vos.MovieVO
import com.androboy.themovies.delegates.MovieItemDelegate
import com.androboy.themovies.mvp.presenter.MovieDetailPresenter
import com.androboy.themovies.mvp.view.MovieDetailView
import com.androboy.themovies.utils.LIST_TYPE
import kotlinx.android.synthetic.main.fragment_movie_detail.view.*
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import androidx.annotation.NonNull
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener



class MovieDetailFragment(private val movieID: Int) : Fragment() , MovieDetailView , MovieItemDelegate{



    override fun onTapMovieItem(movieID: Int) {
        (activity as MainActivity).supportActionBar?.hide()
        (activity as MainActivity).loadFragment(MovieDetailFragment(1))
    }

    override fun showSimilarMovies(movies: List<MovieVO>) {
        mSimilarMovieListAdapter.setNewData(movies.toMutableList())
    }

    override fun showErrorMessage(msg: String) {

    }

    override fun showMovieDetails(movie: MovieVO) {

        view!!.ivMovieDetailPoster.load("http://image.tmdb.org/t/p/w300/${movie.posterPath}")
        view!!.ivBackground.load("http://image.tmdb.org/t/p/w300/${movie.posterPath}") {
            this.transformations(
                BlurTransformation(context!!, 10f, 5f)
            )
        }
        view!!.tvMovieDetailOverview.text = movie.overview

    }

    private lateinit var mPresenter : MovieDetailPresenter
    private lateinit var mSimilarMovieListAdapter : MovieListAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_movie_detail , container , false)


        mSimilarMovieListAdapter = MovieListAdapter(this , LIST_TYPE)



        view.rvDetailMoreLikeThis.adapter = mSimilarMovieListAdapter
        view.rvDetailMoreLikeThis.layoutManager = LinearLayoutManager(context , LinearLayoutManager.HORIZONTAL , false)
        view.btnCloseDetail.setOnClickListener {

            (activity as MainActivity).onBackPressed()
        }

        view.btnMovieDetailPlayVideo.setOnClickListener {
            (activity as MainActivity).playVideo()
        }


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mPresenter = MovieDetailPresenter(movieID)
        mPresenter.initPresenter(this)
        mPresenter.onUiReady()
    }
}