package ru.fylmr.poplibs_nov21.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.fylmr.poplibs_nov21.db.GithubDatabase
import ru.fylmr.poplibs_nov21.db.dao.ReposDao
import ru.fylmr.poplibs_nov21.db.dao.UserDao
import javax.inject.Singleton

@Module
class DbModule {

    @Provides
    @Singleton
    fun db(context: Context): GithubDatabase {
        return GithubDatabase.getInstance(context)
    }

    @Provides
    @Singleton
    fun usersDao(db: GithubDatabase): UserDao {
        return db.userDao
    }

    @Provides
    @Singleton
    fun reposDao(db: GithubDatabase): ReposDao {
        return db.reposDao
    }
}