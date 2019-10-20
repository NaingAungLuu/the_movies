package com.androboy.themovies.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.androboy.themovies.R
import com.androboy.themovies.adapters.MovieListAdapter
import com.androboy.themovies.data.vos.MovieVO
import com.androboy.themovies.delegates.MovieItemDelegate
import com.androboy.themovies.mvp.presenter.MovieSearchResultPresenter
import com.androboy.themovies.mvp.view.MovieSearchView
import com.androboy.themovies.utils.GRID_TYPE
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.fragment_search.view.*
import android.content.Context.INPUT_METHOD_SERVICE
import androidx.core.content.ContextCompat.getSystemService
import android.view.inputmethod.InputMethodManager
import com.androboy.themovies.activities.MainActivity


class SearchFragment : Fragment()  , MovieSearchView , MovieItemDelegate{


    override fun onTapMovieItem(movieID: Int) {
        (activity as MainActivity).supportActionBar?.hide()
        (activity as MainActivity).loadFragment(MovieDetailFragment(movieID))
    }

    override fun showErrorMessage(msg: String) {

    }

    override fun showSearchResults(results: List<MovieVO>) {

        mAdapter.setNewData(results.toMutableList())

    }

    private lateinit var mPresenter : MovieSearchResultPresenter
    private lateinit var mAdapter : MovieListAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_search , container , false)

        mAdapter = MovieListAdapter(this , GRID_TYPE)

        view.rvSearchResult.adapter = mAdapter
        view.rvSearchResult.layoutManager = GridLayoutManager(context , 3)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.btnMovieSearchClearText.setOnClickListener {
            etSearch.setText("")
        }

        mPresenter = MovieSearchResultPresenter()
        mPresenter.initPresenter(this)


        etSearch.setOnEditorActionListener { textView, actionId, event ->

            if (actionId == EditorInfo.IME_ACTION_SEARCH){

                mPresenter.onTapSearch(etSearch.text.toString())
                val imm = activity?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager?
                imm!!.hideSoftInputFromWindow(activity?.currentFocus?.windowToken, 0)

            }

            true
        }


    }
}