package com.zuhaibahmad.jetpacksample.ui.base

interface ISchedulers {
    val main: io.reactivex.Scheduler
    val ios: io.reactivex.Scheduler
}