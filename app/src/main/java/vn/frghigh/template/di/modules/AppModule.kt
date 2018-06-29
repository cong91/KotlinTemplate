package vn.frghigh.template.di.modules

import android.app.Application
import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Room
import android.arch.persistence.room.migration.Migration
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import vn.frghigh.template.App
import vn.frghigh.template.data.DataRepository
import vn.frghigh.template.data.sources.local.MoviesDao
import vn.frghigh.template.data.sources.local.Database
import vn.frghigh.template.data.sources.remote.ApiInterface
import vn.frghigh.template.di.modules.viewmodel.ViewModelModule
import vn.frghigh.template.utils.Constants
import vn.frghigh.template.utils.Utils
import javax.inject.Singleton


@Module
class AppModule{

    companion object {
        val MIGRATION_1_2: Migration = object : Migration(1, 2){
            override fun migrate(database: SupportSQLiteDatabase) {
                // Change the table name to the correct one
                database.execSQL("ALTER TABLE movie RENAME TO movies")
            }
        }
    }

    @Provides
    @Singleton
    fun provideContext(app : App): Context {
        return app.applicationContext
    }

    @Provides
    @Singleton
    fun provideDatabase(context: Context): Database = Room.databaseBuilder(context,
            Database::class.java, Constants.DATABASE_NAME)
            /*.addMigrations(MIGRATION_1_2)*/
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideMoviesDao(database: Database): MoviesDao = database.moviesDao()


    @Provides
    @Singleton
    fun provideUtils(context: Context): Utils = Utils(context)


    @Provides
    @Singleton
    fun provideDataRepository(apiInterface: ApiInterface,
                              moviesDao: MoviesDao, utils: Utils): DataRepository = DataRepository(apiInterface,moviesDao,utils)

}