package ru.fylmr.poplibs_nov21.domain.users

import io.reactivex.rxjava3.core.Single
import ru.fylmr.poplibs_nov21.domain.model.GithubUserModel
import ru.fylmr.poplibs_nov21.network.GithubApiService
import ru.fylmr.poplibs_nov21.network.NetworkStatus
import javax.inject.Inject

class GithubUsersRepository @Inject constructor(
    private val githubApiService: GithubApiService,
    private val githubUsersCache: IGithubUsersCache,
    private val networkStatus: NetworkStatus,
) : IGithubUsersRepository {

    override fun getUsers(): Single<List<GithubUserModel>> = networkStatus.isOnlineSingle()
        .flatMap { isOnline ->
            if (isOnline) {
                githubUsersCache.updateCache(githubApiService.getUsers())
            } else {
                githubUsersCache.retrieveCache()
            }
        }
}