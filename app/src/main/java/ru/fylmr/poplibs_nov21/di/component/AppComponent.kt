package ru.fylmr.poplibs_nov21.di.component

import dagger.Component
import ru.fylmr.poplibs_nov21.di.modules.*
import ru.fylmr.poplibs_nov21.ui.main.MainActivity
import ru.fylmr.poplibs_nov21.ui.main.MainPresenter
import javax.inject.Singleton

@Component(
    modules = [
        ContextModule::class,
        NavigationModule::class,
        DbModule::class,
        CacheModule::class,
        NetworkModule::class,
    ]
)
@Singleton
interface AppComponent {

    fun provideMainPresenter(): MainPresenter

    fun provideUsersSubcomponent(): UsersSubcomponent

    fun provideReposSubcomponent(): ReposSubcomponent

    fun inject(mainActivity: MainActivity)

    fun inject(mainPresenter: MainPresenter)
}