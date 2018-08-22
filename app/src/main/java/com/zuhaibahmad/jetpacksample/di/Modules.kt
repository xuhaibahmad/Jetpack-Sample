package com.zuhaibahmad.jetpacksample.di

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.zuhaibahmad.jetpacksample.BuildConfig
import com.zuhaibahmad.jetpacksample.application.AppConstants
import com.zuhaibahmad.jetpacksample.data.BooksRepository
import com.zuhaibahmad.jetpacksample.data.IBooksRepository
import com.zuhaibahmad.jetpacksample.network.INewYorkTimesBooksApi
import com.zuhaibahmad.jetpacksample.ui.base.AppSchedulers
import com.zuhaibahmad.jetpacksample.ui.base.ISchedulers
import com.zuhaibahmad.jetpacksample.ui.booklisting.BookListingAdapter
import com.zuhaibahmad.jetpacksample.ui.booklisting.BookListingViewModelFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * App module
 */
val appModule = applicationContext {
    factory { AppSchedulers() as ISchedulers }

    bean { BooksRepository(get()) as IBooksRepository }

    bean { BookListingAdapter() }

    bean { BookListingViewModelFactory(get(), get(), get()) }

    bean {
        val logging = HttpLoggingInterceptor()
        logging.level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE

        OkHttpClient.Builder()
            .addInterceptor { chain ->
                chain.proceed(
                    chain.request()
                        .newBuilder()
                        .addHeader("api-key", BuildConfig.NYT_BOOKS_API_KEY)
                        .build()
                )
            }
            .writeTimeout(25, TimeUnit.SECONDS)
            .readTimeout(25, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(logging)
            .build()
    }

    bean {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(get()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(AppConstants.API_BASE_URL)
            .client(get())
            .build()
            .create(INewYorkTimesBooksApi::class.java)
    }

    bean {
        GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()
    }
}

val appModules = listOf(appModule)
