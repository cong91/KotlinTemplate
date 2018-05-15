package vn.frghigh.template.data.database.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import vn.frghigh.template.utils.AppConstants

@Entity(tableName = AppConstants.T_ARTICLE)
data class ArticleEntity(
        @PrimaryKey
        var title: String = "",
        var source: String? = "",
        var author: String? = "",
        var description: String? = "",
        var url: String? = "",
        var urlToImage: String? = "",
        var publishedAt: String? = ""
)