package ru.fylmr.poplibs_nov21.domain.users

import io.reactivex.rxjava3.core.Single
import ru.fylmr.poplibs_nov21.db.dao.UserDao
import ru.fylmr.poplibs_nov21.db.enitity.GithubUserEntity
import ru.fylmr.poplibs_nov21.domain.model.GithubUserModel
import ru.fylmr.poplibs_nov21.network.GithubApiService
import ru.fylmr.poplibs_nov21.network.NetworkStatus
import javax.inject.Inject

class GithubUsersRepository @Inject constructor(
    private val githubApiService: GithubApiService,
    private val userDao: UserDao,
    private val networkStatus: NetworkStatus,
) : IGithubUsersRepository {

    override fun getUsers(): Single<List<GithubUserModel>> = networkStatus.isOnlineSingle()
        .flatMap { isOnline ->
            if (isOnline) {
                githubApiService.getUsers()
                    .flatMap { users ->
                        userDao.insert(
                            users.map {
                                GithubUserEntity(it.id, it.login, it.avatarUrl ?: "", it.reposUrl)
                            }
                        )
                        Single.just(users)
                    }
            } else {
                userDao.getAll()
                    .map { users ->
                        users.map { user ->
                            GithubUserModel(user.id, user.login, user.avatarUrl, user.reposUrl)
                        }
                    }
            }
        }
}