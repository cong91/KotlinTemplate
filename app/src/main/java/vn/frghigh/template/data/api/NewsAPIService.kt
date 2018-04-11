package vn.frghigh.template.data.api

import android.arch.lifecycle.LiveData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import vn.frghigh.template.data.api.model.ArticlesResponse
import vn.frghigh.template.data.api.model.SourceResponse

interface NewsAPIService {
    @GET("sources")
    fun getSources(@Query("language") language: String?,
                   @Query("category") category: String?,
                   @Query("country") country: String?): LiveData<ApiResponse<SourceResponse>>

    @GET("articles")
    fun getArticles(@Query("source") source: String,
                    @Query("sortBy") sortBy: String?,
                    @Query("apiKey") apiKey: String): Call<ArticlesResponse>
}