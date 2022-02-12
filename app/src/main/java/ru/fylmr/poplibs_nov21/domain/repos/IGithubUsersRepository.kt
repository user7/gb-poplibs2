package ru.fylmr.poplibs_nov21.domain.repos

import io.reactivex.rxjava3.core.Single
import ru.fylmr.poplibs_nov21.domain.model.GithubRepoModel

interface IGithubReposRepository {

    fun getRepos(reposUrl: String): Single<List<GithubRepoModel>>
}