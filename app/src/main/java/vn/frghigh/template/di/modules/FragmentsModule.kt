package vn.frghigh.template.di.modules

import vn.frghigh.template.ui.main.menu.MenuFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsModule {

    @ContributesAndroidInjector
    abstract fun provideMenuFragment(): MenuFragment
}