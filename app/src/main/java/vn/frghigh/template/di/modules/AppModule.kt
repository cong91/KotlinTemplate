package vn.frghigh.template.di.modules

import android.content.Context
import vn.frghigh.template.App
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Singleton
    @Provides
    fun provideContext(app: App): Context = app.applicationContext
}