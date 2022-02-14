package ru.fylmr.poplibs_nov21.di.modules

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import ru.fylmr.poplibs_nov21.screens.AppScreens
import ru.fylmr.poplibs_nov21.screens.IScreens

@Module
class NavigationModule {

    @Provides
    fun provideCicerone(): Cicerone<Router> {
        return Cicerone.create()
    }

    @Provides
    fun providesNavigatorHolder(cicerone: Cicerone<Router>): NavigatorHolder {
        return cicerone.getNavigatorHolder()
    }

    @Provides
    fun providesRouter(cicerone: Cicerone<Router>): Router {
        return cicerone.router
    }

    @Provides
    fun providesAppScreens(): IScreens {
        return AppScreens()
    }
}