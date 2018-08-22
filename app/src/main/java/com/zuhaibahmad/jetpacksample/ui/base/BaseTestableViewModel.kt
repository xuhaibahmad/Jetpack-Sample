package com.zuhaibahmad.jetpacksample.ui.base

open class BaseTestableViewModel<V : BaseView>(var schedulers: ISchedulers) : BaseViewModel<V>()