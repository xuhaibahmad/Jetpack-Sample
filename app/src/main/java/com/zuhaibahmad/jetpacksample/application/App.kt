package com.zuhaibahmad.jetpacksample.application

import android.app.Application
import com.zuhaibahmad.jetpacksample.BuildConfig
import com.zuhaibahmad.jetpacksample.di.appModules
import com.zuhaibahmad.jetpacksample.utils.FileLogsTree
import org.koin.android.ext.android.startKoin
import timber.log.Timber

class App: Application() {

    var hasAlreadyLoadedModules = false

    override fun onCreate() {
        super.onCreate()

        initDI()
        initTimber()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            Timber.plant(FileLogsTree(baseContext))
        }
    }

    private fun initDI() {
        if(!hasAlreadyLoadedModules)
            startKoin(this, appModules)
    }

}
