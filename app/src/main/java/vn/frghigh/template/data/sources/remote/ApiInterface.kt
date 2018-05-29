package vn.frghigh.template.data.sources.remote

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import vn.frghigh.template.data.model.Cryptocurrency


interface ApiInterface {

  @GET("ticker/")
  fun getCryptocurrencies(@Query("start") start: String): Observable<List<Cryptocurrency>>
}