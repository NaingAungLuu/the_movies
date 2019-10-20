package com.androboy.themovies.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.androboy.themovies.data.vos.MovieVO
import com.androboy.themovies.data.vos.NowPlaying
import com.androboy.themovies.data.vos.TopRated

@Dao
abstract class TopRatedDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertMovies(movieList : List<TopRated>) : LongArray

    @Query("SELECT * FROM movies INNER JOIN top_rated_movies ON movies.movie_id = top_rated_movies.movie_id")
    abstract fun getTopRatedMovies(): LiveData<List<MovieVO>>

    @Query("DELETE FROM top_rated_movies")
    abstract fun clearTable()
}