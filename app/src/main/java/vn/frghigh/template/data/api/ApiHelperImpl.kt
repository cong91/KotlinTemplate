package vn.frghigh.template.data.api

import android.arch.lifecycle.LiveData
import com.abhinav.newsapp.ui.model.SourceResponse
import retrofit2.Retrofit
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(retrofit: Retrofit): ApiHelper {
    private val apiNews = retrofit.create(NewsAPIService::class.java)
    override fun doServerGetSources(language: String?, category: String?, country: String?) = apiNews.getSources(language,category,country)
}