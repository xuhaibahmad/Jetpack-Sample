package com.zuhaibahmad.jetpacksample.data

import com.zuhaibahmad.jetpacksample.ui.booklisting.Book
import io.reactivex.Single

interface IBooksRepository {
    fun getBooks(): Single<List<Book>>
}
