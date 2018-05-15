package vn.frghigh.template.data.database.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import vn.frghigh.template.utils.AppConstants

@Entity(tableName = AppConstants.T_SOURCE)
class SourceEntity(
        @PrimaryKey()
        var id: String = "",
        var name: String? = "",
        var description: String? = "",
        var url: String? = "",
        var category: String? = "",
        var language: String? = "",
        var country: String? = ""
)