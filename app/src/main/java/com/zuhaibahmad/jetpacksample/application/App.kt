package com.zuhaibahmad.jetpacksample.application

import android.app.Application
import com.zuhaibahmad.jetpacksample.BuildConfig
import com.zuhaibahmad.jetpacksample.utils.FileLogsTree
import timber.log.Timber

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        //initDI()
        initTimber()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            Timber.plant(FileLogsTree(baseContext))
        }
    }

    /*private fun initDI() {
        DI.init(AppInjector.init(this))
    }*/

}
