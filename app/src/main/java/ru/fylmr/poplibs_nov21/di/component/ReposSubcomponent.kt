package ru.fylmr.poplibs_nov21.di.component

import dagger.Subcomponent
import ru.fylmr.poplibs_nov21.di.modules.RepositoryReposModule
import ru.fylmr.poplibs_nov21.di.scope.ReposScope
import ru.fylmr.poplibs_nov21.ui.repos.ReposPresenterFactory

@Subcomponent(
    modules = [
        RepositoryReposModule::class,
    ]
)
@ReposScope
interface ReposSubcomponent {
    fun providePresenterFactory(): ReposPresenterFactory
}