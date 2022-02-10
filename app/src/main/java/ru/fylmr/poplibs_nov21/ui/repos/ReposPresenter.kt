package ru.fylmr.poplibs_nov21.ui.repos

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import ru.fylmr.poplibs_nov21.domain.IGithubReposRepository
import ru.fylmr.poplibs_nov21.model.GithubRepoModel
import ru.fylmr.poplibs_nov21.screens.AppScreens
import ru.fylmr.poplibs_nov21.screens.RepoScreenInitParams
import ru.fylmr.poplibs_nov21.screens.ReposScreenInitParams
import ru.fylmr.poplibs_nov21.screens.UsersScreenInitParams

class ReposPresenter(
    private val router: Router,
    private val reposRepository: IGithubReposRepository,
    private val initModel: ReposScreenInitParams,
) : MvpPresenter<ReposView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        loadData(initModel.url)
    }

    private fun loadData(url: String) {
        reposRepository.getRepos(url)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { repos ->
                    viewState.updateList(repos)
                }, {
                    viewState.showError(it.message)
                }
            )
    }

    fun backPressed(): Boolean {
        router.backTo(AppScreens.usersScreen(UsersScreenInitParams()))
        return true
    }

    fun onRepoClicked(repo: GithubRepoModel) {
        if (repo.name != null) {
            router.navigateTo(
                AppScreens.repoScreen(
                    RepoScreenInitParams(
                        repo.name,
                        repo.forks,
                        repo.watchers,
                        repo.url ?: ""
                    )
                )
            )
        }
    }
}