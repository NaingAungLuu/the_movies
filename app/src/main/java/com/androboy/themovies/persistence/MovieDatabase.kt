package com.androboy.themovies.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.androboy.themovies.data.vos.*
import com.androboy.themovies.persistence.daos.*
import com.androboy.themovies.persistence.typeconverters.GenreTypeConverter
import com.androboy.themovies.persistence.typeconverters.MovieTypeConverter

@Database(entities = [MovieVO::class , NowPlaying::class , TopRated::class , UpComing::class , Popular::class] , version = 10 , exportSchema = false)
@TypeConverters(MovieTypeConverter::class , GenreTypeConverter::class)
abstract class MovieDatabase : RoomDatabase(){

    abstract fun movieDao () : MovieDao
    abstract fun nowPlayingDao() : NowPlayingDao
    abstract fun popularDao(): PopularDao
    abstract fun TopRatedDao() : TopRatedDao
    abstract fun UpComingDao() : UpComingDao

    companion object{

        private var instance : MovieDatabase? = null

        fun getInstance(context: Context):MovieDatabase
        {
            if(instance == null)
            {
                instance  = Room.databaseBuilder(context , MovieDatabase::class.java , "MOVIE_DB")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            val  db = instance!!
            return db
        }

    }

}