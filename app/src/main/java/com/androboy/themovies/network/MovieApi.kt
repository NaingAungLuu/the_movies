package com.androboy.themovies.network

import android.telecom.Call
import com.androboy.themovies.network.response.NowPlayingMovieResponse
import com.androboy.themovies.utils.*
import retrofit2.http.*
import javax.security.auth.callback.Callback

interface MovieApi {

    @GET(NOW_PLAYING)
    fun getNowPlaying(@Query(PARAM_API_KEY) apiKey : String) : retrofit2.Call<NowPlayingMovieResponse>

    @GET(POPULAR)
    fun getPopular(@Query(PARAM_API_KEY) apiKey : String) : retrofit2.Call<NowPlayingMovieResponse>

    @GET(TOP_RATED)
    fun getTopRated(@Query(PARAM_API_KEY) apiKey : String) : retrofit2.Call<NowPlayingMovieResponse>

    @GET(UPCOMING)
    fun getUpComing(@Query(PARAM_API_KEY) apiKey : String) : retrofit2.Call<NowPlayingMovieResponse>

}