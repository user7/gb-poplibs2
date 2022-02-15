package ru.fylmr.poplibs_nov21.domain.repos

import io.reactivex.rxjava3.core.Single
import ru.fylmr.poplibs_nov21.domain.model.GithubRepoModel

interface IGithubReposCache {

    fun updateCache(reposObservable: Single<List<GithubRepoModel>>): Single<List<GithubRepoModel>>

    fun retrieveCache(userId: Long): Single<List<GithubRepoModel>>
}