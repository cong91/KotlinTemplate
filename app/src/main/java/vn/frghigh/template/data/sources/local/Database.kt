package vn.frghigh.template.data.sources.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import vn.frghigh.template.data.model.Movie
import vn.frghigh.template.data.model.MovieDetails

@Database(entities = [(Movie::class),(MovieDetails::class)], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun moviesDao(): MoviesDao
}