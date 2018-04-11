package vn.frghigh.template.data

import android.arch.lifecycle.LiveData
import android.content.Context
import vn.frghigh.template.data.api.Resource
import vn.frghigh.template.data.database.model.SourceEntity

/**
 * Repository class meant to be the only access point to all other data related classes
*/
interface DataManager {
    fun fetchNewsSource(context: Context, language: String?, category: String?, country: String?): LiveData<Resource<List<SourceEntity>>>
}