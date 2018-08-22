package com.zuhaibahmad.jetpacksample.data

import com.zuhaibahmad.jetpacksample.network.response.Book
import com.zuhaibahmad.jetpacksample.network.response.BookReviewResults
import io.reactivex.Single

interface IBooksRepository {
    fun getBooks(): Single<List<Book>>
    fun getReview(isbn: String): Single<BookReviewResults>
}
