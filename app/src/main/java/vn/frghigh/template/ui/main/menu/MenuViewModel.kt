package vn.frghigh.template.ui.main.menu

import vn.frghigh.template.data.DataManager
import vn.frghigh.template.ui.base.BaseViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

open class MenuViewModel @Inject constructor(
        dataManager: DataManager,
        compositeDisposable: CompositeDisposable
) : BaseViewModel(dataManager, compositeDisposable) {

}