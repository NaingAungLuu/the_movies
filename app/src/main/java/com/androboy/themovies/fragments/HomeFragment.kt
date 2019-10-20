package com.androboy.themovies.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.androboy.themovies.R
import com.androboy.themovies.activities.MainActivity
import com.androboy.themovies.adapters.MovieListAdapter
import com.androboy.themovies.data.vos.MovieVO
import com.androboy.themovies.delegates.MovieItemDelegate
import com.androboy.themovies.mvp.presenter.MovieListPresenter
import com.androboy.themovies.mvp.view.MovieListView
import com.androboy.themovies.utils.LIST_TYPE
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() , MovieListView , MovieItemDelegate {



    private lateinit var mPresenter : MovieListPresenter
    private lateinit var mNowPlayingMovieListAdapter : MovieListAdapter
    private lateinit var mPopularMovieListAdapter : MovieListAdapter
    private lateinit var mTopRatedMovieListAdapter : MovieListAdapter
    private lateinit var mUpcomingMovieListAdapter : MovieListAdapter


    override fun showNowComingMovies(movies: List<MovieVO>) {
        mNowPlayingMovieListAdapter.setNewData(movies.toMutableList())

    }

    override fun showPopularMovies(movies: List<MovieVO>) {
        mPopularMovieListAdapter.setNewData(movies.toMutableList())
    }

    override fun showTopRatedMovies(movies: List<MovieVO>) {
        mTopRatedMovieListAdapter.setNewData(movies.toMutableList())
    }

    override fun showUpcomingMovies(movies: List<MovieVO>) {
        mUpcomingMovieListAdapter.setNewData(movies.toMutableList())
        toggleProgressBar()
    }

    override fun showErrorMessage(msg: String) {
        Toast.makeText(view?.context , msg , Toast.LENGTH_LONG).show()
    }

    override fun toggleProgressBar() {
        println(view!!.pbLoading.isVisible)

        if(pbLoading.isVisible)
        {
            pbLoading?.visibility = ProgressBar.INVISIBLE
        }
    }

    override fun onTapMovieItem(movieID : Int) {
        println("Loading the detail fragment")
        (activity as MainActivity).supportActionBar?.hide()
        (activity as MainActivity).loadFragment(MovieDetailFragment(movieID))


//        activity to MainActivity().supportActionBar?.hide()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home , container , false)


        mNowPlayingMovieListAdapter = MovieListAdapter(this , LIST_TYPE)
        mPopularMovieListAdapter = MovieListAdapter(this , LIST_TYPE)
        mTopRatedMovieListAdapter = MovieListAdapter(this , LIST_TYPE)
        mUpcomingMovieListAdapter = MovieListAdapter(this , LIST_TYPE)

        view.rvNowPlaying.adapter = mNowPlayingMovieListAdapter
        view.rvNowPlaying.layoutManager = LinearLayoutManager(view.context , LinearLayoutManager.HORIZONTAL , false)

        view.rvPopular.adapter = mPopularMovieListAdapter
        view.rvPopular.layoutManager = LinearLayoutManager(view.context , LinearLayoutManager.HORIZONTAL , false)

        view.rvUpcoming.adapter = mUpcomingMovieListAdapter
        view.rvUpcoming.layoutManager = LinearLayoutManager(view.context , LinearLayoutManager.HORIZONTAL , false)

        view.rvTopRated.adapter = mTopRatedMovieListAdapter
        view.rvTopRated.layoutManager = LinearLayoutManager(view.context , LinearLayoutManager.HORIZONTAL , false)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).supportActionBar?.show()
        view.pbLoading.visibility = ProgressBar.VISIBLE
        mPresenter = MovieListPresenter()
        mPresenter.initPresenter(this)
        mPresenter.onUiReady((activity as MainActivity))

    }
}