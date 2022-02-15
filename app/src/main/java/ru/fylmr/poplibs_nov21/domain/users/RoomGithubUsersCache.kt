package ru.fylmr.poplibs_nov21.domain.users

import io.reactivex.rxjava3.core.Single
import ru.fylmr.poplibs_nov21.db.dao.UserDao
import ru.fylmr.poplibs_nov21.db.enitity.GithubUserEntity
import ru.fylmr.poplibs_nov21.domain.model.GithubUserModel

class RoomGithubUsersCache(private val userDao: UserDao) : IGithubUsersCache {

    override fun updateCache(intake: Single<List<GithubUserModel>>): Single<List<GithubUserModel>> {
        return intake.flatMap { users ->
            userDao.insert(
                users.map {
                    GithubUserEntity(it.id, it.login, it.avatarUrl ?: "", it.reposUrl)
                }
            )
            Single.just(users)
        }
    }

    override fun retrieveCache(): Single<List<GithubUserModel>> {
        return userDao.getAll().map { users ->
            users.map { GithubUserModel(it.id, it.login, it.avatarUrl, it.reposUrl) }
        }
    }
}