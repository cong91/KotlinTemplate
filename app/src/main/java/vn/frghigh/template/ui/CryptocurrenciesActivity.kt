package vn.frghigh.template.ui;

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_cryptocurrencies.*
import vn.frghigh.template.R
import vn.frghigh.template.data.model.Cryptocurrency
import vn.frghigh.template.utils.Constants
import vn.frghigh.template.utils.InfiniteScrollListener
import java.util.*
import javax.inject.Inject

class CryptocurrenciesActivity : AppCompatActivity() {

    @Inject
    lateinit var cryptocurrenciesViewModelFactory: CryptocurrenciesViewModelFactory
    var cryptocurrenciesAdapter = CryptocurrenciesAdapter(ArrayList())
    lateinit var cryptocurrenciesViewModel: CryptocurrenciesViewModel
    var currentPage = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cryptocurrencies)
        AndroidInjection.inject(this)

        initializeRecycler()

        cryptocurrenciesViewModel = ViewModelProviders.of(this, cryptocurrenciesViewModelFactory).get(
                CryptocurrenciesViewModel::class.java)

        progressBar.visibility = View.VISIBLE
        loadData()

        cryptocurrenciesViewModel.cryptocurrenciesResult().observe(this,
                Observer<List<Cryptocurrency>> {
                    if (it != null) {
                        val position = cryptocurrenciesAdapter.itemCount
                        cryptocurrenciesAdapter.addCryptocurrencies(it)
                        recycler.adapter = cryptocurrenciesAdapter
                        recycler.scrollToPosition(position - Constants.LIST_SCROLLING)
                    }
                })

        cryptocurrenciesViewModel.cryptocurrenciesError().observe(this, Observer<String> {
            if (it != null) {
                Toast.makeText(this, resources.getString(R.string.cryptocurrency_error_message) + it,
                        Toast.LENGTH_SHORT).show()
            }
        })

        cryptocurrenciesViewModel.cryptocurrenciesLoader().observe(this, Observer<Boolean> {
            if (it == false) progressBar.visibility = View.GONE
        })
    }

    private fun initializeRecycler() {
        val gridLayoutManager = GridLayoutManager(this, 1)
        gridLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recycler.apply {
            setHasFixedSize(true)
            layoutManager = gridLayoutManager
            addOnScrollListener(InfiniteScrollListener({ loadData() }, gridLayoutManager))
        }
    }

    fun loadData() {
        cryptocurrenciesViewModel.loadCryptocurrencies(Constants.LIMIT, currentPage * Constants.OFFSET)
        currentPage++
    }

    override fun onDestroy() {
        cryptocurrenciesViewModel.disposeElements()
        super.onDestroy()
    }
}
