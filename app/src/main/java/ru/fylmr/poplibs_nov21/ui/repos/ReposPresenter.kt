package ru.fylmr.poplibs_nov21.ui.repos

import android.util.Log
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import ru.fylmr.poplibs_nov21.App
import ru.fylmr.poplibs_nov21.domain.model.GithubRepoModel
import ru.fylmr.poplibs_nov21.domain.model.GithubUserModel
import ru.fylmr.poplibs_nov21.domain.repos.IGithubReposRepository
import javax.inject.Inject

class ReposPresenter(
    private val userModel: GithubUserModel,
) : MvpPresenter<ReposView>() {

    @Inject
    lateinit var reposRepository: IGithubReposRepository

    @Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        App.instance.appComponent.inject(this)

        reposRepository.getRepos(userModel)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { repos ->
                    viewState.showRepos(repos)
                },
                {
                    Log.e("Repos", "Error getting repos", it)
                }
            )

    }

    fun onItemClicked(repo: GithubRepoModel) {
        // todo
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}