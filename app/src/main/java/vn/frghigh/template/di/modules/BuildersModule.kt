package vn.frghigh.template.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import vn.frghigh.template.ui.CryptocurrenciesActivity

@Module
abstract class BuildersModule {

  @ContributesAndroidInjector
  abstract fun contributeCryptocurrenciesActivity(): CryptocurrenciesActivity
}