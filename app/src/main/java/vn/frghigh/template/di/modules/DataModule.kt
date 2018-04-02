package vn.frghigh.template.di.modules

import vn.frghigh.template.data.DataManager
import vn.frghigh.template.data.DataManagerImpl
import vn.frghigh.template.data.api.ApiHelper
import vn.frghigh.template.data.api.ApiHelperImpl
import vn.frghigh.template.data.database.DatabaseHelper
import vn.frghigh.template.data.database.DatabaseHelperImpl
import vn.frghigh.template.data.preferences.PreferencesHelper
import vn.frghigh.template.data.preferences.PreferencesHelperImpl
import dagger.Module
import dagger.Provides
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
    fun provideDatabaseHelper(databaseHelperImpl: DatabaseHelperImpl): DatabaseHelper = databaseHelperImpl

    @Singleton
    @Provides
    fun providePreferencesHelper(preferencesHelperImpl: PreferencesHelperImpl): PreferencesHelper = preferencesHelperImpl
}