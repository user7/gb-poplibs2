package ru.fylmr.poplibs_nov21.domain

import io.reactivex.rxjava3.core.Single
import ru.fylmr.poplibs_nov21.model.GithubRepoModel
import ru.fylmr.poplibs_nov21.network.GithubApiService

class GithubReposRepository(private val githubApiService: GithubApiService) : IGithubReposRepository {
    override fun getRepos(url: String): Single<List<GithubRepoModel>> {
        return githubApiService.getRepos(url)
    }
}

