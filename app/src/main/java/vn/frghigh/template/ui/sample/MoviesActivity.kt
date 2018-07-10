package vn.frghigh.template.ui.sample

import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import vn.frghigh.template.R
import vn.frghigh.template.data.model.Movie
import vn.frghigh.template.databinding.ActivityMoviesBinding
import vn.frghigh.template.ui.base.BaseActivity
import vn.frghigh.template.ui.base.adapter.SingleTypeAdapter
import vn.frghigh.template.utils.extension.observe
import java.lang.Boolean

class MoviesActivity : BaseActivity<ActivityMoviesBinding, MoviesViewModel>() {
    override val classToken: Class<MoviesViewModel>
        get() = MoviesViewModel::class.java

    override fun layoutId(): Int {
        return R.layout.activity_movies
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("ABC", "========> ")
        initActivity()
        viewModel.loadMovies().doOnNext {
            Log.i("ABC"," loadMovies ==========> " + it.size);
            (vdBinding.movieList.adapter as SingleTypeAdapter<Movie>).set(it.orEmpty())
        }
    }

    fun initActivity() {
        observe(viewModel.movies, ::renderMoviesList)
        vdBinding.movieList.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        vdBinding.movieList.adapter = SingleTypeAdapter<Movie>(this, R.layout.row_movie)
//        moviesAdapter.clickListener = { movie, navigationExtras ->
//            navigator.showMovieDetails(activity!!, movie, navigationExtras) }
    }

    private fun renderMoviesList(movies: List<Movie>?) {

//        moviesAdapter.collection = movies.orEmpty()
//        hideProgress()
    }
//    private fun handleFailure(failure: Failure?) {
//        when (failure) {
//            is NetworkConnection -> renderFailure(R.string.failure_network_connection)
//            is ServerError -> renderFailure(R.string.failure_server_error)
//            is ListNotAvailable -> renderFailure(R.string.failure_movies_list_unavailable)
//        }
//    }
}
