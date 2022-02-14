package ru.fylmr.poplibs_nov21.ui.main

import android.os.Bundle
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.fylmr.poplibs_nov21.App
import ru.fylmr.poplibs_nov21.R
import ru.fylmr.poplibs_nov21.ui.base.BackButtonListener
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(R.layout.activity_main), MainView {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val navigator = AppNavigator(this, R.id.container)

    private val presenter by moxyPresenter { MainPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        App.instance.appComponent.inject(this)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        // super.onBackPressed()

        supportFragmentManager.fragments.forEach {
            if (it is BackButtonListener && it.backPressed()) {
                return
            }
        }
        presenter.backPressed()
    }
}