package vn.frghigh.template.data.api

import android.arch.lifecycle.LiveData
import com.abhinav.newsapp.ui.model.SourceResponse
import io.reactivex.Flowable
import retrofit2.http.Query

/**
 *  Interface meant to expose network related methods
 */
interface ApiHelper {
    fun doServerGetSources(language: String?,
                   category: String?,
                   country: String?) : LiveData<ApiResponse<SourceResponse>>
}