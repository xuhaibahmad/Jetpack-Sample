package com.zuhaibahmad.jetpacksample.utils

import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.BiFunction
import java.util.concurrent.TimeUnit

fun Disposable.addToCompositeSubscriptions(compositeDisposable: CompositeDisposable): Disposable {
    compositeDisposable.add(this)
    return this
}

operator fun CompositeDisposable.plusAssign(subscribe: Disposable) {
    this.add(subscribe)
}

object RxUtils {

    fun <T> debounceImmediate(duration: Long, timeUnit: TimeUnit): ObservableTransformer<T, T> =
        ObservableTransformer { upstream ->
            upstream.publish { p ->
                Observable.merge(
                    p.throttleFirst(duration, timeUnit),
                    p.debounce(duration, timeUnit)
                )
                    .distinctUntilChanged()
            }
        }

    fun countDown(timeLength: Long): Observable<Long> = if (timeLength >= 0)
        Observable.interval(0, 1, TimeUnit.SECONDS)
            .map { currentTime -> timeLength - currentTime }
            .take(timeLength + 1)
    else Observable.just(0)

    fun <T, R> toPair(): BiFunction<T, R, Pair<T, R>> = BiFunction { t1, t2 -> Pair(t1, t2) }
}