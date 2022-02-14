package ru.fylmr.poplibs_nov21.ui.main

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.fylmr.poplibs_nov21.App
import ru.fylmr.poplibs_nov21.screens.IScreens
import javax.inject.Inject

class MainPresenter : MvpPresenter<MainView>() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var screens: IScreens

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        App.instance.appComponent.inject(this)

        router.replaceScreen(screens.usersScreen())
    }

    fun backPressed() {
        router.exit()
    }
}