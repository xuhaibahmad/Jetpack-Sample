package com.zuhaibahmad.jetpacksample.data

import com.zuhaibahmad.jetpacksample.application.AppConstants
import com.zuhaibahmad.jetpacksample.network.INewYorkTimesBooksApi
import com.zuhaibahmad.jetpacksample.network.NoResultException
import com.zuhaibahmad.jetpacksample.network.response.Book
import io.reactivex.Single
import io.reactivex.rxkotlin.toSingle

class BooksRepository(val repository: INewYorkTimesBooksApi) : IBooksRepository {

    override fun getBooks(): Single<List<Book>> = repository.getBooks()
        .flatMap {
            if (it.status == AppConstants.STATUS_OK) it.toSingle()
            else Single.error(NoResultException())
        }
        .map { it.results.lists.map { it.books }.flatten() }

    override fun getReview(isbn: String) = repository.getReview(isbn)
        .flatMap {
            when {
                it.status == AppConstants.STATUS_OK -> {
                    if (it.numResults > 0) it.toSingle()
                    else Single.error(NoResultException())
                }
                else -> Single.error(NoResultException())
            }
        }
        .map { it.results.firstOrNull() ?: throw NoResultException() }
}