package vn.frghigh.template.ui.sample

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import vn.frghigh.template.data.DataRepository
import vn.frghigh.template.data.model.Movie
import vn.frghigh.template.ui.base.BaseViewModel
import javax.inject.Inject

class MoviesViewModel @Inject constructor(private val repository: DataRepository) : BaseViewModel() {
    var movies: MutableLiveData<List<Movie>> = MutableLiveData()
    fun loadMovies() = repository.getMovies()
    private fun handleMovieList(movies: List<Movie>) {
        this.movies.value = movies.map { it }
    }
}