package vn.frghigh.template.data.database.model

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import vn.frghigh.template.utils.AppConstants


@Dao
interface SourceDao {

    @Query("SELECT * FROM " + AppConstants.T_SOURCE)
    fun getAllNewsSource(): LiveData<List<SourceEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSources(source: List<SourceEntity>)

    @Delete
    fun deleteSource(source: List<SourceEntity>)

//    fun insertSources(source: List<Source>) {
//
//        insertSources(*sourceEntityArray.toTypedArray())
//    }
}