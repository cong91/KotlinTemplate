package vn.frghigh.template.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import vn.frghigh.template.data.database.model.ArticleDao
import vn.frghigh.template.data.database.model.ArticleEntity
import vn.frghigh.template.data.database.model.SourceDao
import vn.frghigh.template.data.database.model.SourceEntity

/**
 *  Interface meant to expose database related methods
 */
@Database(entities = arrayOf(SourceEntity::class, ArticleEntity::class), version = 1)
abstract class DatabaseHelper : RoomDatabase() {
   abstract fun getArticleDao(): ArticleDao
   abstract fun getSourceDao(): SourceDao
}