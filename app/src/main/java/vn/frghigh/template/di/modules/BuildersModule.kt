package vn.frghigh.template.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import vn.frghigh.template.di.scope.ActivityScope
import vn.frghigh.template.ui.sample.MoviesActivity

@Module
abstract class BuildersModule {
    @ActivityScope
    @ContributesAndroidInjector
    abstract fun moviesActivity(): MoviesActivity
}