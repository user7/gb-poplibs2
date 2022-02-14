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
    private val reposDao: ReposDao,
    private val networkStatus: NetworkStatus
) : IGithubReposRepository {

    override fun getRepos(user: GithubUserModel): Single<List<GithubRepoModel>> = networkStatus.isOnlineSingle()
        .flatMap { isOnline ->
            if (isOnline) {
                githubApiService.getRepos(user.reposUrl)
                    .flatMap { repos ->
                        reposDao.insert(repos.map { GithubRepoEntity(it.id, it.name, it.owner.ownerId) })
                        Single.just(repos)
                    }
            } else {
                reposDao.getAll(user.id)
                    .map { list ->
                        list.map { repo -> GithubRepoModel(repo.name, repo.id, Owner(repo.userId)) }
                    }
            }
        }
}