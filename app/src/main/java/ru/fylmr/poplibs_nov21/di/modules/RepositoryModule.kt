package ru.fylmr.poplibs_nov21.di.modules

import dagger.Binds
import dagger.Module
import ru.fylmr.poplibs_nov21.domain.repos.GithubReposRepository
import ru.fylmr.poplibs_nov21.domain.repos.IGithubReposRepository
import ru.fylmr.poplibs_nov21.domain.users.GithubUsersRepository
import ru.fylmr.poplibs_nov21.domain.users.IGithubUsersRepository

@Module
interface RepositoryModule {

    @Binds
    fun provideUserRepository(impl: GithubUsersRepository): IGithubUsersRepository

    @Binds
    fun provideRepoRepository(impl: GithubReposRepository): IGithubReposRepository
}