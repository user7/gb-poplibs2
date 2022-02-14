package ru.fylmr.poplibs_nov21

import android.app.Application
import ru.fylmr.poplibs_nov21.di.component.DaggerAppComponent
import ru.fylmr.poplibs_nov21.di.modules.ContextModule

class App : Application() {

    val appComponent by lazy {
        DaggerAppComponent.builder()
            .contextModule(ContextModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        _instance = this
    }

    companion object {

        private var _instance: App? = null
        val instance
            get() = _instance!!
    }
}