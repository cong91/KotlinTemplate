package vn.frghigh.template.di.modules

import android.arch.persistence.room.Room
import android.content.Context
import vn.frghigh.template.data.DataManager
import vn.frghigh.template.data.DataManagerImpl
import vn.frghigh.template.data.api.ApiHelper
import vn.frghigh.template.data.api.ApiHelperImpl
import vn.frghigh.template.data.database.DatabaseHelper
import vn.frghigh.template.data.preferences.PreferencesHelper
import vn.frghigh.template.data.preferences.PreferencesHelperImpl
import dagger.Module
import dagger.Provides
import vn.frghigh.template.utils.AppConstants
import javax.inject.Singleton

@Module(includes = arrayOf(NetworkModule::class))
class DataModule {

    @Singleton
    @Provides
    fun provideDataManager(dataManagerImpl: DataManagerImpl): DataManager = dataManagerImpl

    @Singleton
    @Provides
    fun provideApiHelper(apiHelperImpl: ApiHelperImpl): ApiHelper = apiHelperImpl

    @Singleton
    @Provides
    fun provideDatabaseHelper(context: Context): DatabaseHelper =
            Room.databaseBuilder(context, DatabaseHelper::class.java, AppConstants.DB_NAME).build()

    @Singleton
    @Provides
    fun providePreferencesHelper(preferencesHelperImpl: PreferencesHelperImpl): PreferencesHelper = preferencesHelperImpl
}