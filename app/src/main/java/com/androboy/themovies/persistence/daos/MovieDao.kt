package com.androboy.themovies.persistence.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.androboy.themovies.data.vos.MovieVO
import com.androboy.themovies.data.vos.NowPlaying


@Dao
abstract class MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertMovies(movieList : List<MovieVO>) : LongArray

}