package com.androboy.themovies.network.dataAgents

import com.androboy.themovies.data.vos.MovieVO
import com.androboy.themovies.network.MovieApi
import com.androboy.themovies.network.response.NowPlayingMovieResponse
import com.androboy.themovies.network.response.SearchResponse
import com.androboy.themovies.utils.API_KEY
import com.androboy.themovies.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitDataAgent : MovieDataAgent {



    private lateinit var movieApi : MovieApi

    init {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(15 , TimeUnit.SECONDS)
            .readTimeout(15 , TimeUnit.SECONDS)
            .writeTimeout(15 , TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        movieApi = retrofit.create(MovieApi::class.java)
    }

    override fun getNowPlaying(
        apiKey: String,
        language : String,
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (msg: String) -> Unit
    ) {

        val call = movieApi.getNowPlaying(API_KEY)
        call.enqueue(object : Callback<NowPlayingMovieResponse>{

            override fun onFailure(call: Call<NowPlayingMovieResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<NowPlayingMovieResponse>,
                response: Response<NowPlayingMovieResponse>
            ) {

                val movieResponse = response.body()

                if(movieResponse != null)
                {
                        onSuccess(movieResponse.results)
                }
                else
                {
                    onFailure("Network Failed!")
                }

            }

        })

    }


    override fun getPopular(
        apiKey: String,
        language : String,
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (msg: String) -> Unit
    ) {

        val call = movieApi.getPopular(API_KEY)
        call.enqueue(object : Callback<NowPlayingMovieResponse>{

            override fun onFailure(call: Call<NowPlayingMovieResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<NowPlayingMovieResponse>,
                response: Response<NowPlayingMovieResponse>
            ) {

                val movieResponse = response.body()

                if(movieResponse != null)
                {
                    onSuccess(movieResponse.results)
                }
                else
                {
                    onFailure("Network Failed!")
                }

            }

        })

    }


    override fun getTopRated(
        apiKey: String,
        language : String,
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (msg: String) -> Unit
    ) {

        val call = movieApi.getTopRated(API_KEY)
        call.enqueue(object : Callback<NowPlayingMovieResponse>{

            override fun onFailure(call: Call<NowPlayingMovieResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<NowPlayingMovieResponse>,
                response: Response<NowPlayingMovieResponse>
            ) {

                val movieResponse = response.body()

                if(movieResponse != null)
                {
                    onSuccess(movieResponse.results)
                }
                else
                {
                    onFailure("Network Failed!")
                }

            }

        })

    }


    override fun getUpcoming(
        apiKey: String,
        language : String,
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (msg: String) -> Unit
    ) {

        val call = movieApi.getUpComing(API_KEY)
        call.enqueue(object : Callback<NowPlayingMovieResponse>{

            override fun onFailure(call: Call<NowPlayingMovieResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<NowPlayingMovieResponse>,
                response: Response<NowPlayingMovieResponse>
            ) {

                val movieResponse = response.body()

                if(movieResponse != null)
                {
                    onSuccess(movieResponse.results)
                }
                else
                {
                    onFailure("Network Failed!")
                }

            }

        })
    }

    override fun getSimilarMovies(
        apiKey: String,
        movieID : Int,
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (msg: String) -> Unit
    ) {
        val call = movieApi.getSimilarMovies(movieID  , apiKey)
        call.enqueue(object : Callback<NowPlayingMovieResponse>{



            override fun onFailure(call: Call<NowPlayingMovieResponse>, t: Throwable) {

                onFailure(t.localizedMessage)

            }

            override fun onResponse(
                call: Call<NowPlayingMovieResponse>,
                response: Response<NowPlayingMovieResponse>
            ) {

                    val movieResponse = response.body()

                    if(response != null)
                    {
                        movieResponse?.let {
                            onSuccess(it.results)
                        }
                    }
                    else
                    {
                        onFailure("Network Failed")
                    }

            }
        })
    }

    override fun getMovieDetails(
        movieID: Int,
        apiKey: String,
        onSuccess: (MovieVO) -> Unit,
        onFailure: (msg: String) -> Unit
    ) {
        val call = movieApi.getMovieDetails(movieID , apiKey)
        call.enqueue(object : Callback<MovieVO>{

            override fun onFailure(call: Call<MovieVO>, t: Throwable) {

                onFailure(t.localizedMessage)

            }

            override fun onResponse(call: Call<MovieVO>, response: Response<MovieVO>) {

                val movieResponse = response.body()
                if(response != null)
                {
                    movieResponse?.let(onSuccess)
                }
                else
                {
                    onFailure("Network Error")
                }


            }


        })

    }

    override fun searchMovie(
        apiKey: String,
        query: String,
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (msg: String) -> Unit
    ) {

        val call = movieApi.searchMovie(apiKey , query )
        call.enqueue(object : Callback<SearchResponse>{

            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {

                onFailure(t.localizedMessage)

            }

            override fun onResponse(
                call: Call<SearchResponse>,
                response: Response<SearchResponse>
            ) {

                val searchResponse = response.body()

                if(searchResponse != null)
                {
                    onSuccess(searchResponse.results)
                }
                else
                {
                    onFailure("Network Error Occurred")
                }

            }

        })

    }
}