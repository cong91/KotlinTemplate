package vn.frghigh.template.data.api

import android.arch.lifecycle.LiveData
import io.reactivex.Flowable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import vn.frghigh.template.data.api.model.ArticlesResponse
import vn.frghigh.template.data.api.model.SourceResponse

/**
 *  Interface meant to expose network related methods
 */
interface ApiHelper {
    fun doServerGetSources(language: String?,
                   category: String?,
                   country: String?) : LiveData<ApiResponse<SourceResponse>>

    fun doServerGetArticles(source: String,
                    sortBy: String?,
                    apiKey: String): Call<ArticlesResponse>
}