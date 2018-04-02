package vn.frghigh.template

import android.app.Activity
import android.app.Application
import vn.frghigh.template.di.AppInjector
import vn.frghigh.template.utils.ReleaseTree
import vn.frghigh.template.utils.LinkingDebugTree
import com.squareup.leakcanary.LeakCanary
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import javax.inject.Inject

open class App : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return
        }

        LeakCanary.install(this)
        injectDaggerComponents()

        if (BuildConfig.DEBUG) {
            Timber.plant(LinkingDebugTree())
        } else {
            Timber.plant(ReleaseTree())
        }
    }

    open fun injectDaggerComponents() {
        AppInjector.inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityInjector
    }
}