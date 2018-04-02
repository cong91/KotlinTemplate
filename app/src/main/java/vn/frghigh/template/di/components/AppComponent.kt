package vn.frghigh.template.di.components

import vn.frghigh.template.App
import vn.frghigh.template.di.modules.ActivitiesModule
import vn.frghigh.template.di.modules.AppModule
import vn.frghigh.template.di.modules.DataModule
import vn.frghigh.template.di.modules.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.BindsInstance
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AndroidInjectionModule::class,
        ActivitiesModule::class,
        ViewModelModule::class,
        DataModule::class,
        AppModule::class
))
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: App): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}