package ru.fylmr.poplibs_nov21.ui.repos

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import ru.fylmr.poplibs_nov21.domain.model.GithubRepoModel

interface ReposView : MvpView {

    @AddToEndSingle
    fun showRepos(repos: List<GithubRepoModel>?)
}