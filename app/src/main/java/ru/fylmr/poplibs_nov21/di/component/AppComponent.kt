package ru.fylmr.poplibs_nov21.di.component

import dagger.Component
import ru.fylmr.poplibs_nov21.di.modules.*
import ru.fylmr.poplibs_nov21.ui.main.MainActivity
import ru.fylmr.poplibs_nov21.ui.main.MainPresenter
import ru.fylmr.poplibs_nov21.ui.repos.ReposPresenter
import ru.fylmr.poplibs_nov21.ui.repos.ReposPresenterFactory
import ru.fylmr.poplibs_nov21.ui.users.UsersPresenter
import javax.inject.Singleton

@Component(
    modules = [
        ContextModule::class,
        NavigationModule::class,
        DbModule::class,
        CacheModule::class,
        NetworkModule::class,
        RepositoryModule::class,
    ]
)
@Singleton
interface AppComponent {

    fun provideMainPresenter(): MainPresenter

    fun provideUsersPresenter(): UsersPresenter

    fun provideReposPresenterFactory(): ReposPresenterFactory

    fun inject(mainActivity: MainActivity)

    fun inject(mainPresenter: MainPresenter)

    fun inject(usersPresenter: UsersPresenter)

    fun inject(reposPresenter: ReposPresenter)
}