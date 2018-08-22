package com.zuhaibahmad.jetpacksample.di

import com.zuhaibahmad.jetpacksample.data.BooksRepository
import com.zuhaibahmad.jetpacksample.data.IBooksRepository
import com.zuhaibahmad.jetpacksample.ui.base.AppSchedulers
import com.zuhaibahmad.jetpacksample.ui.base.ISchedulers
import com.zuhaibahmad.jetpacksample.ui.booklisting.BookListingAdapter
import com.zuhaibahmad.jetpacksample.ui.booklisting.BookListingViewModelFactory
import org.koin.dsl.module.applicationContext

/**
 * App module
 */
val appModule = applicationContext {
    factory { AppSchedulers() as ISchedulers }

    bean { BooksRepository() as IBooksRepository }

    bean { BookListingAdapter() }

    bean { BookListingViewModelFactory(get(),get(),get()) }
}

val appModules = listOf(appModule)
