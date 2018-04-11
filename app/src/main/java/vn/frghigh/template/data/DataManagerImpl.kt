package vn.frghigh.template.data

import android.arch.lifecycle.LiveData
import android.content.Context
import vn.frghigh.template.data.api.ApiHelper
import vn.frghigh.template.data.api.ApiResponse
import vn.frghigh.template.data.api.NetworkBoundResource
import vn.frghigh.template.data.api.Resource
import vn.frghigh.template.data.api.model.SourceResponse
import vn.frghigh.template.data.database.DatabaseHelper
import vn.frghigh.template.data.database.model.SourceEntity
import vn.frghigh.template.data.preferences.PreferencesHelper
import vn.frghigh.template.utility.RateLimiter
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class DataManagerImpl @Inject constructor(
        private val databaseHelper: DatabaseHelper,
        private val preferencesHelper: PreferencesHelper,
        private val apiHelper: ApiHelper
) : DataManager {
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
                //NewsDBHelper.getInstance(context).getSourceDao().insertSources(sourceList)
            }

            override fun shouldFetch(data: List<SourceEntity>?): Boolean = repoRateLimiter.shouldFetch("all")

            override fun loadFromDb(): LiveData<List<SourceEntity>> {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun createCall(): LiveData<ApiResponse<SourceResponse>> {
                return apiHelper.doServerGetSources(language,category,country)
            }

        }.asLiveData()
    }

}