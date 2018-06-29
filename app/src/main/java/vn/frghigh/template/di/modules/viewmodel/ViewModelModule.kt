package vn.frghigh.template.di.modules.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import vn.frghigh.template.di.modules.viewmodel.ViewModelKey
import vn.frghigh.template.utils.ViewModelFactory


@Module
abstract class ViewModelModule {

//
//    @Binds
//    @IntoMap
//    @ViewModelKey(MainViewModel::class)
//    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(PostsViewModel::class)
//    abstract fun bindPostsViewModel(viewModel: PostsViewModel): ViewModel
//

    @Binds
    abstract fun provideViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory


}