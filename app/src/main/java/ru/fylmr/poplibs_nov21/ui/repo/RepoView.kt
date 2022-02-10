package ru.fylmr.poplibs_nov21.ui.repo

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import ru.fylmr.poplibs_nov21.screens.RepoScreenInitParams

interface RepoView : MvpView {
    @AddToEndSingle
    fun showData(repo: RepoScreenInitParams)
}