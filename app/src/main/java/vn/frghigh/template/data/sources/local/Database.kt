package vn.frghigh.template.data.sources.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import vn.frghigh.template.data.model.Cryptocurrency

@Database(entities = arrayOf(Cryptocurrency::class), version = 8)
abstract class Database : RoomDatabase() {
    abstract fun cryptocurrenciesDao(): CryptocurrenciesDao
}