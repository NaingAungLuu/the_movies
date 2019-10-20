package com.androboy.themovies.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.androboy.themovies.data.vos.MovieVO
import com.androboy.themovies.data.vos.NowPlaying
import com.androboy.themovies.data.vos.UpComing

@Dao
abstract class UpComingDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertMovies(movieList : List<UpComing>) : LongArray

    @Query("SELECT * FROM movies INNER JOIN upcoming_movies ON movies.movie_id = upcoming_movies.movie_id")
    abstract fun getUpComingMovies(): LiveData<List<MovieVO>>

    @Query("DELETE FROM upcoming_movies")
    abstract fun clearTable()

}