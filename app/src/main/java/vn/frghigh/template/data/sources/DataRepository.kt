package vn.frghigh.template.data

import io.reactivex.Observable
import vn.frghigh.template.data.model.Movie
import vn.frghigh.template.data.model.MovieDetails
import vn.frghigh.template.data.sources.local.MoviesDao
import vn.frghigh.template.data.sources.remote.ApiInterface
import vn.frghigh.template.utils.Utils
import javax.inject.Inject


class DataRepository @Inject constructor(val apiInterface: ApiInterface,
                                         val moviesDao: MoviesDao, val utils: Utils) {


    fun getMovies() : Observable<List<Movie>>{
        val hasConnection = utils.isConnectedToInternet()
        var observableFromApi: Observable<List<Movie>>? = null
        if (hasConnection) {
            observableFromApi = getMoviesFromApi()
        }
        val observableFromDb = getMoviesFromDb()
        return if (hasConnection) Observable.concatArrayEager(observableFromApi, observableFromDb)
        else observableFromDb
    }
    fun getMoviesDetail(id : Int) : Observable<MovieDetails>{
        val hasConnection = utils.isConnectedToInternet()
        var observableFromApi: Observable<MovieDetails>? = null
        if (hasConnection) {
            observableFromApi = getMovieDetailsFromApi(id)
        }
        val observableFromDb = getMovieDetailsFromDb(id)
        return if (hasConnection) Observable.concat(observableFromApi, observableFromDb)
        else observableFromDb
    }

    private fun getMovieDetailsFromDb(id: Int): Observable<MovieDetails> {
        return moviesDao.queryMovieDetails(id).toObservable().doOnNext{

        }
    }

    private fun getMovieDetailsFromApi(id: Int): Observable<MovieDetails>? {
        return apiInterface.movieDetails(id).doOnNext{
            moviesDao.insertMovieDetail(it)
        }
    }

    private fun getMoviesFromDb(): Observable<List<Movie>> {
        return moviesDao.queryMovies()
                .toObservable()
                .doOnNext {

                }
    }




    private fun getMoviesFromApi(): Observable<List<Movie>>? {
        return apiInterface.movies().doOnNext{ moviesDao.insertMovie(it)}
    }

}