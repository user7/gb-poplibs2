package ru.fylmr.poplibs_nov21.domain

import io.reactivex.rxjava3.core.Single
import ru.fylmr.poplibs_nov21.model.GithubRepoModel

interface IGithubReposRepository {
    fun getRepos(url: String): Single<List<GithubRepoModel>>
}