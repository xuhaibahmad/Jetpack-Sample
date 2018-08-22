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

    fun start(){
        subscribeToDataEvents()
        subscribeToUiEvents()
    }

    fun subscribeToDataEvents() {
        refreshData()
    }

    fun subscribeToUiEvents() {
        adapter.clicks.subscribe { getReview(it.primaryIsbn10) }.disposeOnDestroy()
    }

    fun refreshData() = repository.getBooks()
        .subscribeOn(schedulers.ios)
        .observeOn(schedulers.main)
        .doOnSubscribe {
            loadBooks(emptyList())
            view.showProgress()
        }
        .doFinally { view.hideProgress() }
        .doOnSuccess { Timber.i("Loaded ${it.size} Books!") }
        .subscribe({ loadBooks(it) }, Timber::e)
        .disposeOnDestroy()

    private fun getReview(isbn: String) = repository.getReview(isbn)
        .subscribeOn(schedulers.ios)
        .observeOn(schedulers.main)
        .doOnSubscribe { view.showProgress() }
        .doFinally { view.hideProgress() }
        .map { it.url }
        .doOnSuccess { Timber.i("Review Url: $it") }
        .subscribe({ view.openReview(it) }, { it.message?.let { view.showMessage(it) } })
        .disposeOnDestroy()

    private fun loadBooks(books: List<Book>) = adapter.apply {
        this.books.clear()
        this.books.addAll(books)
        notifyDataSetChanged()
    }
}
