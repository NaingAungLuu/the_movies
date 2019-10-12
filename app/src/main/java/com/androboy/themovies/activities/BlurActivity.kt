package com.androboy.themovies.activities

import android.os.Bundle
import com.androboy.themovies.R
import kotlinx.android.synthetic.main.fragment_movie_detail.*

class BlurActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_movie_detail)
        blurringView.setBlurredView(ivBackground)
    }
}