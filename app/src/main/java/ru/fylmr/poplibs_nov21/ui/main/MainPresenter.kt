package ru.fylmr.poplibs_nov21.ui.main

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.fylmr.poplibs_nov21.App
import ru.fylmr.poplibs_nov21.screens.IScreens
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val router: Router,
    private val screens: IScreens,
) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        router.replaceScreen(screens.usersScreen())
    }

    fun backPressed() {
        router.exit()
    }
}