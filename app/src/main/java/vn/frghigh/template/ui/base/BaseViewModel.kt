package vn.frghigh.template.ui.base

import android.arch.lifecycle.ViewModel
import vn.frghigh.template.data.DataRepository
import javax.inject.Inject
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KClass

class BaseViewModel @Inject constructor(private val repository: DataRepository) : ViewModel() {

}