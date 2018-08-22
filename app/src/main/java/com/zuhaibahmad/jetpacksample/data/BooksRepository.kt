package com.zuhaibahmad.jetpacksample.data

import com.zuhaibahmad.jetpacksample.ui.booklisting.Book
import io.reactivex.Single

class BooksRepository : IBooksRepository {
    // Todo: Load data from API
    override fun getBooks(): Single<List<Book>> = Single.just((1..10).map { Book("Book #$it") })
}