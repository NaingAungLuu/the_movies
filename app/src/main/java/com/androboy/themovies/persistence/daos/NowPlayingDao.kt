package com.androboy.themovies.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.androboy.themovies.data.vos.NowPlaying
import com.androboy.themovies.data.vos.MovieVO

@Dao
abstract class NowPlayingDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertMovies(movieList : List<NowPlaying>) : LongArray

    @Query("SELECT * FROM movies INNER JOIN now_playing_movies ON movies.movie_id = now_playing_movies.movie_id")
    abstract fun getNowPlayingMovies():LiveData<List<MovieVO>>

    @Query("DELETE FROM now_playing_movies")
    abstract fun clearTable()




}