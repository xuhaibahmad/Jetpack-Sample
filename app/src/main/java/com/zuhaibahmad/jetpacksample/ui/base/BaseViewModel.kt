package com.zuhaibahmad.jetpacksample.ui.base

import androidx.lifecycle.ViewModel
import com.zuhaibahmad.jetpacksample.utils.addToCompositeSubscriptions
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel<View : BaseView> : ViewModel() {

    lateinit var view: View

    protected val disposeOnDestroy: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        disposeOnDestroy.dispose()
        super.onCleared()
    }

    fun Disposable.disposeOnDestroy() {
        addToCompositeSubscriptions(disposeOnDestroy)
    }
}