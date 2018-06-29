package vn.frghigh.template

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import vn.frghigh.template.di.component.DaggerAppComponent


class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent.builder().application(this).build()
        appComponent.inject(this)
        return appComponent
    }
}