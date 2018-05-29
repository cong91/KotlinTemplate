package vn.frghigh.template

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import vn.frghigh.template.di.component.DaggerAppComponent
import vn.frghigh.template.di.modules.AppModule
import vn.frghigh.template.di.modules.NetModule
import javax.inject.Inject

class App : Application(), HasActivityInjector {

    @Inject lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .netModule(NetModule(BuildConfig.URL))
                .build().inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

}