package com.androboy.themovies.network

import com.androboy.themovies.data.vos.MovieVO
import com.androboy.themovies.network.response.NowPlayingMovieResponse
import com.androboy.themovies.network.response.SearchResponse
import com.androboy.themovies.utils.*
import retrofit2.http.*

interface MovieApi {

    @GET(NOW_PLAYING)
    fun getNowPlaying(@Query(PARAM_API_KEY) apiKey : String) : retrofit2.Call<NowPlayingMovieResponse>

    @GET(POPULAR)
    fun getPopular(@Query(PARAM_API_KEY) apiKey : String) : retrofit2.Call<NowPlayingMovieResponse>

    @GET(TOP_RATED)
    fun getTopRated(@Query(PARAM_API_KEY) apiKey : String) : retrofit2.Call<NowPlayingMovieResponse>

    @GET(UPCOMING)
    fun getUpComing(@Query(PARAM_API_KEY) apiKey : String) : retrofit2.Call<NowPlayingMovieResponse>

    @GET("${BASE_URL}movie/{movie_id}/similar")
    fun getSimilarMovies( @Path("movie_id") movieID : Int , @Query(PARAM_API_KEY) apiKey : String ) : retrofit2.Call<NowPlayingMovieResponse>

    @GET("${BASE_URL}movie/{movie_id}")
    fun getMovieDetails( @Path("movie_id") movieID : Int , @Query(PARAM_API_KEY) apiKey : String ) : retrofit2.Call<MovieVO>

    @GET(SEARCH)
    fun searchMovie(@Query(PARAM_API_KEY) apiKey : String , @Query("query") searchQuery : String) : retrofit2.Call<SearchResponse>

}