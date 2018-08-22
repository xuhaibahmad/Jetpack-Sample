package com.zuhaibahmad.jetpacksample.ui.base

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AppSchedulers : ISchedulers {
    override val main: Scheduler get() = AndroidSchedulers.mainThread()
    override val ios: Scheduler get() = Schedulers.io()
}