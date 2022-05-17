package ru.fylmr.poplibs_nov21.di.modules

import dagger.Module
import dagger.Provides
import ru.fylmr.poplibs_nov21.di.scope.UsersScope
import ru.fylmr.poplibs_nov21.domain.users.GithubUsersRepository
import ru.fylmr.poplibs_nov21.domain.users.IGithubUsersCache
import ru.fylmr.poplibs_nov21.domain.users.IGithubUsersRepository
import ru.fylmr.poplibs_nov21.network.GithubApiService
import ru.fylmr.poplibs_nov21.network.NetworkStatus

@Module
class RepositoryUsersModule {
    @Provides
    @UsersScope
    fun provideUsersRepository(
        apiService: GithubApiService,
        githubUsersCache: IGithubUsersCache,
        networkStatus: NetworkStatus,
    ): IGithubUsersRepository {
        return GithubUsersRepository(apiService, githubUsersCache, networkStatus)
    }
}