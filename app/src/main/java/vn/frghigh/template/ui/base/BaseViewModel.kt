package vn.frghigh.template.ui.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import vn.frghigh.template.data.DataRepository
import vn.frghigh.template.utils.exception.Failure
import javax.inject.Inject
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KClass

abstract class BaseViewModel : ViewModel() {

    var failure: MutableLiveData<Failure> = MutableLiveData()

    protected fun handleFailure(failure: Failure) {
        this.failure.value = failure
    }
}