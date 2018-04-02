package vn.frghigh.template.di.modules

import vn.frghigh.template.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesModule {

    @ContributesAndroidInjector (modules = arrayOf(FragmentsModule::class))
    abstract fun provideMainActivity(): MainActivity
}