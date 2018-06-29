package vn.frghigh.template.di.component
import android.app.Application
import dagger.BindsInstance
import dagger.Component

import vn.frghigh.template.App
import vn.frghigh.template.di.modules.AppModule
import vn.frghigh.template.di.modules.BuildersModule
import vn.frghigh.template.di.modules.NetModule
import javax.inject.Singleton
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import vn.frghigh.template.di.modules.viewmodel.ViewModelModule

@Singleton
@Component(
    modules = [(AndroidSupportInjectionModule::class), (BuildersModule::class), (AppModule::class), (NetModule::class),(ViewModelModule::class)]
)
interface AppComponent : AndroidInjector<App> {
  @Component.Builder
  interface Builder {
    @BindsInstance
    fun application(application: App): AppComponent.Builder

    fun build(): AppComponent
  }
}