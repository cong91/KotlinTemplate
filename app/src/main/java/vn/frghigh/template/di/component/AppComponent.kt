package vn.frghigh.template.di.component
import dagger.Component
import dagger.android.AndroidInjectionModule
import vn.frghigh.template.App
import vn.frghigh.template.di.modules.AppModule
import vn.frghigh.template.di.modules.BuildersModule
import vn.frghigh.template.di.modules.NetModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = arrayOf(AndroidInjectionModule::class, BuildersModule::class, AppModule::class,
        NetModule::class)
)
interface AppComponent {
  fun inject(app: App)
}