package vn.frghigh.template.data

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import vn.frghigh.template.BuildConfig
import vn.frghigh.template.data.api.ApiHelper
import vn.frghigh.template.data.api.ApiResponse
import vn.frghigh.template.data.api.NetworkBoundResource
import vn.frghigh.template.data.api.Resource
import vn.frghigh.template.data.api.model.ArticlesResponse
import vn.frghigh.template.data.api.model.SourceResponse
import vn.frghigh.template.data.database.DatabaseHelper
import vn.frghigh.template.data.database.model.SourceEntity
import vn.frghigh.template.data.preferences.PreferencesHelper
import vn.frghigh.template.utility.RateLimiter
import vn.frghigh.template.utils.AppConstants
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class DataManagerImpl @Inject constructor(
        private val databaseHelper: DatabaseHelper,
        private val preferencesHelper: PreferencesHelper,
        private val apiHelper: ApiHelper) : DataManager {
    override fun getNewsArticles(source: String, sortBy: String?): LiveData<ArticlesResponse> {
        val liveDataArticlesResponse: MutableLiveData<ArticlesResponse> = MutableLiveData()
        apiHelper.doServerGetArticles(source, sortBy, AppConstants.API_KEY).enqueue(object : Callback<ArticlesResponse> {
            override fun onFailure(call: Call<ArticlesResponse>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<ArticlesResponse>, response: Response<ArticlesResponse>) {
                liveDataArticlesResponse.value = response.body()
            }
        })
        return liveDataArticlesResponse
    }

    val repoRateLimiter = RateLimiter<String>(10, TimeUnit.MINUTES)

    override fun fetchNewsSource(context: Context, language: String?, category: String?, country: String?): LiveData<Resource<List<SourceEntity>>> {
        return object : NetworkBoundResource<List<SourceEntity>,SourceResponse>(){
            override fun onFetchFailed() {
                repoRateLimiter.reset("all")
            }
            override fun saveCallResult(item: SourceResponse) {

                var sourceList = ArrayList<SourceEntity>()
                item.sources.forEach {
                    var sourceEntity = SourceEntity()
                    sourceEntity.id = it.id
                    sourceEntity.category = it.category
                    sourceEntity.country = it.country
                    sourceEntity.description = it.description
                    sourceEntity.language = it.language
                    sourceEntity.name = it.name
                    sourceEntity.url = it.url
                    sourceList.add(sourceEntity)
                }
                databaseHelper.getSourceDao().insertSources(sourceList)
            }

            override fun shouldFetch(data: List<SourceEntity>?): Boolean = repoRateLimiter.shouldFetch("all")

            override fun loadFromDb(): LiveData<List<SourceEntity>> {
                return databaseHelper.getSourceDao().getAllNewsSource()
            }

            override fun createCall(): LiveData<ApiResponse<SourceResponse>> {
                return apiHelper.doServerGetSources(language,category,country)
            }

        }.asLiveData()
    }

}