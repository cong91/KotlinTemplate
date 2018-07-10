package vn.frghigh.template.di.modules.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import vn.frghigh.template.di.modules.viewmodel.ViewModelKey
import vn.frghigh.template.ui.sample.MoviesViewModel
import vn.frghigh.template.utils.ViewModelFactory


@Module
abstract class ViewModelModule {

//
    @Binds
    @IntoMap
    @ViewModelKey(MoviesViewModel::class)
    abstract fun bindMoviesViewModel(viewModel: MoviesViewModel): ViewModel
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(PostsViewModel::class)
//    abstract fun bindPostsViewModel(viewModel: PostsViewModel): ViewModel
//

    @Binds
    abstract fun provideViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory


}