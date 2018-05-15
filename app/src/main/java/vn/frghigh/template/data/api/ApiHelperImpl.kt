package vn.frghigh.template.data.api

import android.arch.lifecycle.LiveData
import retrofit2.Call
import retrofit2.Retrofit
import vn.frghigh.template.data.api.model.ArticlesResponse
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(retrofit: Retrofit): ApiHelper {
    private val apiNews = retrofit.create(NewsAPIService::class.java)
    override fun doServerGetArticles(source: String, sortBy: String?, apiKey: String) = apiNews.getArticles(source,sortBy,apiKey)
    override fun doServerGetSources(language: String?, category: String?, country: String?) = apiNews.getSources(language,category,country)
}