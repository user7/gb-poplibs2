package ru.fylmr.poplibs_nov21.domain.repos

import io.reactivex.rxjava3.core.Single
import ru.fylmr.poplibs_nov21.db.dao.ReposDao
import ru.fylmr.poplibs_nov21.db.enitity.GithubRepoEntity
import ru.fylmr.poplibs_nov21.domain.model.GithubRepoModel
import ru.fylmr.poplibs_nov21.domain.model.Owner

class RoomGithubReposCache(private val reposDao: ReposDao) : IGithubReposCache {

    override fun updateCache(reposObservable: Single<List<GithubRepoModel>>): Single<List<GithubRepoModel>> {
        return reposObservable.flatMap { users ->
            reposDao.insert(users.map { GithubRepoEntity(it.id, it.name, it.owner.ownerId) })
            Single.just(users)
        }
    }

    override fun retrieveCache(userId: Long): Single<List<GithubRepoModel>> {
        return reposDao.getAll(userId).map { users ->
            users.map { GithubRepoModel(it.name, it.id, Owner(it.userId)) }
        }
    }
}