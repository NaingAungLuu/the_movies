package com.androboy.themovies.mvp.presenter

import androidx.lifecycle.ViewModel
import com.androboy.themovies.data.model.MovieModelImpl
import com.androboy.themovies.mvp.view.BaseView

abstract class BasePresenter<T : BaseView> : ViewModel() {



    protected lateinit var mView : T

    open fun initPresenter(view : T)
    {
        this.mView = view
    }




}