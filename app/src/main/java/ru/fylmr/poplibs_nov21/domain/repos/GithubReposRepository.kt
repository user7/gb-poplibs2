package ru.fylmr.poplibs_nov21.domain.repos

import io.reactivex.rxjava3.core.Single
import ru.fylmr.poplibs_nov21.db.dao.ReposDao
import ru.fylmr.poplibs_nov21.db.enitity.GithubRepoEntity
import ru.fylmr.poplibs_nov21.domain.model.GithubRepoModel
import ru.fylmr.poplibs_nov21.domain.model.GithubUserModel
import ru.fylmr.poplibs_nov21.domain.model.Owner
import ru.fylmr.poplibs_nov21.network.GithubApiService
import ru.fylmr.poplibs_nov21.network.NetworkStatus
import javax.inject.Inject

class GithubReposRepository @Inject constructor(
    private val githubApiService: GithubApiService,
    private val githubReposCache: IGithubReposCache,
    private val networkStatus: NetworkStatus
) : IGithubReposRepository {

    override fun getRepos(user: GithubUserModel): Single<List<GithubRepoModel>> =
        networkStatus.isOnlineSingle().flatMap { isOnline ->
            if (isOnline) {
                githubReposCache.updateCache(githubApiService.getRepos(user.reposUrl))
            } else {
                githubReposCache.retrieveCache(user.id)
            }
        }
}