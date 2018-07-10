package vn.frghigh.template.ui.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import vn.frghigh.template.BR
import javax.inject.Inject

abstract class BaseFragment<TB : ViewDataBinding,T : ViewModel> : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var vdBinding: TB
    internal fun firstTimeCreated(savedInstanceState: Bundle?) = savedInstanceState == null

    lateinit var viewModel : T
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        vdBinding = DataBindingUtil.inflate(inflater, layoutId(), container, false)
        return vdBinding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vdBinding.setVariable(BR.viewModel,viewModel)
        vdBinding.executePendingBindings()
    }

    abstract fun layoutId(): Int
    open fun onBackPressed() {}
}