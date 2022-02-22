package ru.fylmr.poplibs_nov21.di.modules

import dagger.Module
import dagger.Provides
import ru.fylmr.poplibs_nov21.db.dao.ReposDao
import ru.fylmr.poplibs_nov21.db.dao.UserDao
import ru.fylmr.poplibs_nov21.domain.repos.IGithubReposCache
import ru.fylmr.poplibs_nov21.domain.repos.RoomGithubReposCache
import ru.fylmr.poplibs_nov21.domain.users.IGithubUsersCache
import ru.fylmr.poplibs_nov21.domain.users.RoomGithubUsersCache
import javax.inject.Singleton

@Module
class CacheModule {

    @Provides
    @Singleton
    fun usersCache(userDao: UserDao): IGithubUsersCache {
        return RoomGithubUsersCache(userDao)
    }

    @Provides
    @Singleton
    fun reposCache(reposDao: ReposDao): IGithubReposCache {
        return RoomGithubReposCache(reposDao)
    }
}