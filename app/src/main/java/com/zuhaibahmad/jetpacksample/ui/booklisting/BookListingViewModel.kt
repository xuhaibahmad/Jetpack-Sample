package com.zuhaibahmad.jetpacksample.ui.booklisting

import com.zuhaibahmad.jetpacksample.data.IBooksRepository
import com.zuhaibahmad.jetpacksample.ui.base.BaseTestableViewModel
import com.zuhaibahmad.jetpacksample.ui.base.ISchedulers
import io.reactivex.Single
import timber.log.Timber
import java.util.concurrent.TimeUnit

class BookListingViewModel(
    private val repository: IBooksRepository,
    scheduler: ISchedulers
) : BaseTestableViewModel<BookListingView>(scheduler) {

    val adapter = BookListingAdapter()

    init {
        refreshData()
    }

    // Todo: Remove delay
    fun refreshData() = repository.getBooks()
        .delay(2, TimeUnit.SECONDS)
        .doOnSubscribe {
            loadBooks(emptyList())
            view.showProgress()
        }
        .doFinally { view.hideProgress() }
        .subscribeOn(schedulers.ios)
        .observeOn(schedulers.main)
        .doOnSuccess { Timber.i("Loaded ${it.size} Books!") }
        .subscribe({ loadBooks(it) }, Timber::e)
        .disposeOnDestroy()

    private fun loadBooks(books: List<Book>) = adapter.apply {
        this.books.clear()
        this.books.addAll(books)
        notifyDataSetChanged()
    }
}
