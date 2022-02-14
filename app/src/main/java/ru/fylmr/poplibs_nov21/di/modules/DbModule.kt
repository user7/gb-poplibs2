package ru.fylmr.poplibs_nov21.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.fylmr.poplibs_nov21.db.GithubDatabase
import ru.fylmr.poplibs_nov21.db.dao.ReposDao
import ru.fylmr.poplibs_nov21.db.dao.UserDao

@Module
class DbModule {

    @Provides
    fun db(context: Context): GithubDatabase {
        return GithubDatabase.getInstance(context)
    }

    @Provides
    fun usersDao(db: GithubDatabase): UserDao {
        return db.userDao
    }

    @Provides
    fun reposDao(db: GithubDatabase): ReposDao {
        return db.reposDao
    }
}