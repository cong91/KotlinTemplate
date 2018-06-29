package vn.frghigh.template.data.sources.local
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Observable
import io.reactivex.Single
import vn.frghigh.template.data.model.Movie
import vn.frghigh.template.data.model.MovieDetails

@Dao
interface MoviesDao {
    @Query("SELECT * FROM movies")
    fun queryMovies() : Single<List<Movie>>
    @Query("SELECT * FROM movie_details WHERE id = :id")
    fun queryMovieDetails(id : Int) : Single<MovieDetails>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: Movie)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movies: List<Movie>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieDetail(detail: MovieDetails)
}