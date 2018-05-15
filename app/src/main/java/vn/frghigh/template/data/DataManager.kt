package vn.frghigh.template.data

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import vn.frghigh.template.data.api.Resource
import vn.frghigh.template.data.api.model.ArticlesResponse
import vn.frghigh.template.data.database.model.SourceEntity

/**
 * Repository class meant to be the only access point to all other data related classes
*/
interface DataManager {
    fun fetchNewsSource(context: Context, language: String?, category: String?, country: String?): LiveData<Resource<List<SourceEntity>>>
    fun getNewsArticles(source: String, sortBy: String?): LiveData<ArticlesResponse>
}