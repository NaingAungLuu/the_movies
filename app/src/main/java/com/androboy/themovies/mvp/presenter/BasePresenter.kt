package com.androboy.themovies.mvp.presenter

import com.androboy.themovies.data.model.MovieModelImpl
import com.androboy.themovies.mvp.view.BaseView

abstract class BasePresenter<T : BaseView> {



    protected lateinit var mView : T

    open fun initPresenter(view : T)
    {
        this.mView = view
    }

    open fun onCreate(){}


}