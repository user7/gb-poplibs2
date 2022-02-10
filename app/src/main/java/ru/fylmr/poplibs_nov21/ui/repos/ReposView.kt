package ru.fylmr.poplibs_nov21.ui.repos

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.Skip
import ru.fylmr.poplibs_nov21.model.GithubRepoModel

interface ReposView : MvpView {
    @AddToEndSingle
    fun updateList(repos: List<GithubRepoModel>)

    @Skip
    fun showError(message: String?)
}
