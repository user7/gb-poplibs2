package ru.fylmr.poplibs_nov21.di.modules

import dagger.Module
import dagger.Provides
import ru.fylmr.poplibs_nov21.db.dao.ReposDao
import ru.fylmr.poplibs_nov21.db.dao.UserDao
import ru.fylmr.poplibs_nov21.domain.repos.GithubReposRepository
import ru.fylmr.poplibs_nov21.domain.repos.IGithubReposRepository
import ru.fylmr.poplibs_nov21.domain.users.GithubUsersRepository
import ru.fylmr.poplibs_nov21.domain.users.IGithubUsersRepository
import ru.fylmr.poplibs_nov21.network.GithubApiService
import ru.fylmr.poplibs_nov21.network.NetworkStatus

@Module
class RepositoryModule {

    @Provides
    fun usersRepo(
        apiService: GithubApiService,
        usersDao: UserDao,
        networkStatus: NetworkStatus
    ): IGithubUsersRepository {
        return GithubUsersRepository(apiService, usersDao, networkStatus)
    }

    @Provides
    fun reposRepo(
        apiService: GithubApiService,
        reposDao: ReposDao,
        networkStatus: NetworkStatus
    ): IGithubReposRepository {
        return GithubReposRepository(apiService, reposDao, networkStatus)
    }
}