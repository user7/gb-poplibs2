package ru.fylmr.poplibs_nov21

import android.app.Application
import android.util.Log
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import ru.fylmr.poplibs_nov21.network.NetworkStatus

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

        networkStatus.networkStatusSubject.subscribe {
            Log.d("NetworkStatus", "Доступна ли сеть: $it")
        }
    }

    companion object {

        private var _instance: App? = null
        val instance
            get() = _instance!!
    }
}