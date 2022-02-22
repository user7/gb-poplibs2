package ru.fylmr.poplibs_nov21.di.modules

import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.fylmr.poplibs_nov21.di.scope.ReposScope
import ru.fylmr.poplibs_nov21.domain.repos.GithubReposRepository
import ru.fylmr.poplibs_nov21.domain.repos.IGithubReposCache
import ru.fylmr.poplibs_nov21.domain.repos.IGithubReposRepository
import ru.fylmr.poplibs_nov21.network.GithubApiService
import ru.fylmr.poplibs_nov21.network.NetworkStatus
import javax.inject.Singleton

@Module
class RepositoryReposModule {
    @Provides
    @ReposScope
    fun provideReposRepository(
        apiService: GithubApiService,
        githubReposCache: IGithubReposCache,
        networkStatus: NetworkStatus,
    ): IGithubReposRepository {
        return GithubReposRepository(apiService, githubReposCache, networkStatus)
    }
}