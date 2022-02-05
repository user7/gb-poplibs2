package ru.fylmr.poplibs_nov21

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import ru.fylmr.poplibs_nov21.network.NetworkStatus
import ru.fylmr.poplibs_nov21.rxjava.subscribeToMultiThreadingSingle

class App : Application() {

    private val cicerone: Cicerone<Router> by lazy { Cicerone.create() }

    val navigationHolder
        get() = cicerone.getNavigatorHolder()

    val router
        get() = cicerone.router

    private val networkStatus by lazy { NetworkStatus(this) }

    override fun onCreate() {
        super.onCreate()
        _instance = this

        subscribeToMultiThreadingSingle()
    }

    companion object {

        private var _instance: App? = null
        val instance
            get() = _instance!!
    }
}