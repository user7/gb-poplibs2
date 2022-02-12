package ru.fylmr.poplibs_nov21.ui.repos

import moxy.MvpPresenter
import ru.fylmr.poplibs_nov21.model.GithubRepoModel
import ru.fylmr.poplibs_nov21.model.GithubUserModel

class ReposPresenter(
    private val userModel: GithubUserModel
) : MvpPresenter<ReposView>() {

    fun onItemClicked(repo: GithubRepoModel) {

    }
}