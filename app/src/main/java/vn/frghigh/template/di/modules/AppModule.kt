package vn.frghigh.template.di.modules

import android.app.Application
import android.arch.lifecycle.ViewModelProvider
import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Room
import android.arch.persistence.room.migration.Migration
import dagger.Module
import dagger.Provides
import vn.frghigh.template.data.sources.local.CryptocurrenciesDao
import vn.frghigh.template.data.sources.local.Database
import vn.frghigh.template.ui.CryptocurrenciesViewModelFactory
import vn.frghigh.template.utils.Constants
import vn.frghigh.template.utils.Utils
import javax.inject.Singleton


@Module
class AppModule(val app: Application) {

    companion object {
        val MIGRATION_1_2: Migration = object : Migration(1, 2){
            override fun migrate(database: SupportSQLiteDatabase) {
                // Change the table name to the correct one
                database.execSQL("ALTER TABLE cryptocurrency RENAME TO cryptocurrencies")
            }
        }
    }

    @Provides
    @Singleton
    fun provideApplication(): Application = app

    @Provides
    @Singleton
    fun provideCryptocurrenciesDatabase(app: Application): Database = Room.databaseBuilder(app,
            Database::class.java, Constants.DATABASE_NAME)
            /*.addMigrations(MIGRATION_1_2)*/
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideCryptocurrenciesDao(
            database: Database): CryptocurrenciesDao = database.cryptocurrenciesDao()

    @Provides
    @Singleton
    fun provideCryptocurrenciesViewModelFactory(
            factory: CryptocurrenciesViewModelFactory): ViewModelProvider.Factory = factory

    @Provides
    @Singleton
    fun provideUtils(): Utils = Utils(app)
}