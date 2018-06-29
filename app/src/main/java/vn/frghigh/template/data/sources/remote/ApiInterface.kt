package vn.frghigh.template.data.sources.remote

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import vn.frghigh.template.data.model.Movie
import vn.frghigh.template.data.model.MovieDetails


interface ApiInterface {
    companion object {
        private const val PARAM_MOVIE_ID = "movieId"
        private const val MOVIES = "movies.json"
        private const val MOVIE_DETAILS = "movie_0{$PARAM_MOVIE_ID}.json"
    }

    @GET(MOVIES) fun movies(): Observable<List<Movie>>
    @GET(MOVIE_DETAILS) fun movieDetails(@Path(PARAM_MOVIE_ID) movieId: Int): Observable<MovieDetails>
}