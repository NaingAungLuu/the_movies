package com.androboy.themovies.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.androboy.themovies.data.vos.MovieVO
import com.androboy.themovies.data.vos.NowPlaying
import com.androboy.themovies.data.vos.Popular

@Dao
abstract class PopularDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertMovies(movieList : List<Popular>) : LongArray

    @Query("SELECT * FROM movies INNER JOIN popular_movies ON movies.movie_id = popular_movies.movie_id")
    abstract fun getPopularMovies(): LiveData<List<MovieVO>>

    @Query("DELETE FROM popular_movies")
    abstract fun clearTable()

}