package ru.fylmr.poplibs_nov21.ui.repo

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.fylmr.poplibs_nov21.screens.AppScreens
import ru.fylmr.poplibs_nov21.screens.RepoScreenInitParams
import ru.fylmr.poplibs_nov21.screens.ReposScreenInitParams

class RepoPresenter(
    private val router: Router,
    private val initModel: RepoScreenInitParams,
) : MvpPresenter<RepoView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.showData(initModel)
    }

    fun backPressed(): Boolean {
        router.backTo(AppScreens.reposScreen(ReposScreenInitParams(initModel.reposUrl)))
        return true
    }
}