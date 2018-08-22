package com.zuhaibahmad.jetpacksample.data

import com.zuhaibahmad.jetpacksample.network.response.Book
import io.reactivex.Single

interface IBooksRepository {
    fun getBooks(): Single<List<Book>>
}
