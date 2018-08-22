package com.zuhaibahmad.jetpacksample.ui.booklisting

import com.zuhaibahmad.jetpacksample.data.IBooksRepository
import com.zuhaibahmad.jetpacksample.network.response.Book
import com.zuhaibahmad.jetpacksample.ui.base.BaseTestableViewModel
import com.zuhaibahmad.jetpacksample.ui.base.ISchedulers
import timber.log.Timber

class BookListingViewModel(
    private val repository: IBooksRepository,
    val adapter: BookListingAdapter,
    scheduler: ISchedulers
) : BaseTestableViewModel<BookListingView>(scheduler) {

    init {
        refreshData()
    }

    fun subscribeToUiEvents() {
        // Todo: Open book review
        adapter.clicks.subscribe { view.showMessage("${it.title} clicked!") }.disposeOnDestroy()
    }

    fun refreshData() = repository.getBooks()
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
