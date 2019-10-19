package com.androboy.themovies.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.androboy.themovies.R
import com.androboy.themovies.activities.MainActivity
import com.androboy.themovies.adapters.HomeMovieListAdapter
import com.androboy.themovies.data.vos.MovieVO
import com.androboy.themovies.delegates.MovieItemDelegate
import com.androboy.themovies.mvp.presenter.MovieDetailPresenter
import com.androboy.themovies.mvp.view.MovieDetailView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_movie_detail.*
import kotlinx.android.synthetic.main.fragment_movie_detail.view.*

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

        Glide.with(view!!).load("http://image.tmdb.org/t/p/w300/${movie.posterPath}").into(ivMovieDetailPoster)
        Glide.with(view!!).load("http://image.tmdb.org/t/p/w300/${movie.posterPath}").into(ivBackground)
        view!!.tvMovieDetailOverview.text = movie.overview
        view!!.blurringView.setBlurredView(view!!.ivBackground)

    }

    private lateinit var mPresenter : MovieDetailPresenter
    private lateinit var mSimilarMovieListAdapter : HomeMovieListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_movie_detail , container , false)


        mSimilarMovieListAdapter = HomeMovieListAdapter(this)

        mPresenter = MovieDetailPresenter(movieID)
        mPresenter.initPresenter(this)
        mPresenter.onCreate()

        view.rvDetailMoreLikeThis.adapter = mSimilarMovieListAdapter
        view.rvDetailMoreLikeThis.layoutManager = LinearLayoutManager(context , LinearLayoutManager.HORIZONTAL , false)
        view.btnCloseDetail.setOnClickListener {

            (activity as MainActivity).loadFragment(HomeFragment())
        }


        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }
}