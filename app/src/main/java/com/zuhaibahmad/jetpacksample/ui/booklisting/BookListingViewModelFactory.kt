package com.zuhaibahmad.jetpacksample.ui.booklisting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zuhaibahmad.jetpacksample.data.IBooksRepository
import com.zuhaibahmad.jetpacksample.ui.base.ISchedulers

class BookListingViewModelFactory(
    private val repository: IBooksRepository,
    private val adapter: BookListingAdapter,
    private val scheduler: ISchedulers
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BookListingViewModel::class.java)) {
            return BookListingViewModel(repository, adapter, scheduler) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}