package vn.frghigh.template.ui.main

import vn.frghigh.template.ui.main.menu.MenuFragment
import com.rcosteira.kotlintemplate.utils.addFragment
import vn.frghigh.template.R
import vn.frghigh.template.ui.main.MainActivity
import javax.inject.Inject

class MainNavigationController @Inject constructor(private val mainActivity: MainActivity) {

    private val containerId: Int = R.id.container

    fun navigateToMenu() {
        val menuFragment = MenuFragment()

        mainActivity.addFragment(menuFragment, containerId)
    }
}