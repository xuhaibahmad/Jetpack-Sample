package com.zuhaibahmad.jetpacksample.network

import com.zuhaibahmad.jetpacksample.network.response.BooksOverviewListResponse
import io.reactivex.Single
import retrofit2.http.GET

interface INewYorkTimesBooksApi {

    @GET("lists/overview.json")
    fun getBooks(): Single<BooksOverviewListResponse>

}