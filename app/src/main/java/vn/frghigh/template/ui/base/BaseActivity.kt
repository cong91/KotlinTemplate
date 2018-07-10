package vn.frghigh.template.ui.base

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.Nullable
import android.util.Log
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject
import vn.frghigh.template.BR



abstract class BaseActivity<TB : ViewDataBinding,T : BaseViewModel> : DaggerAppCompatActivity() {
    protected abstract val classToken: Class<T>
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel : T
    lateinit var vdBinding: TB


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView(savedInstanceState)
    }
    private fun initView(savedInstanceState: Bundle?){
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(classToken)
        vdBinding = DataBindingUtil.setContentView(this, layoutId())
        if (!vdBinding.setVariable(BR.viewModel, viewModel)) {
            throw IllegalArgumentException("You should add 'viewModel' variable")
        }
    }
    abstract fun layoutId() : Int

}