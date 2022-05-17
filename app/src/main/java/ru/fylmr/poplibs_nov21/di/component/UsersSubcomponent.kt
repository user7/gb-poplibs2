package ru.fylmr.poplibs_nov21.di.component

import dagger.Subcomponent
import ru.fylmr.poplibs_nov21.di.modules.RepositoryUsersModule
import ru.fylmr.poplibs_nov21.di.scope.UsersScope
import ru.fylmr.poplibs_nov21.ui.users.UsersPresenter

@Subcomponent(
    modules = [
        RepositoryUsersModule::class,
    ]
)
@UsersScope
interface UsersSubcomponent {
    fun provideReposSubcomponent(): ReposSubcomponent

    fun provideUsersPresenter(): UsersPresenter
}