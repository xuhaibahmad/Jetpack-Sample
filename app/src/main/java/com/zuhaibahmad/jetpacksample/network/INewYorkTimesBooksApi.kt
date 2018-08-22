package com.zuhaibahmad.jetpacksample.network

import com.zuhaibahmad.jetpacksample.network.response.BookReviewResponse
import com.zuhaibahmad.jetpacksample.network.response.BooksOverviewListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface INewYorkTimesBooksApi {

    @GET("lists/overview.json")
    fun getBooks(): Single<BooksOverviewListResponse>

    @GET("reviews.json")
    fun getReview(@Query("isbn") request: String): Single<BookReviewResponse>

}