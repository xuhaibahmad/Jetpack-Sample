package com.zuhaibahmad.jetpacksample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zuhaibahmad.jetpacksample.ui.booklisting.BookListingFragment

class BookListingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.book_listing_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, BookListingFragment.newInstance())
                .commitNow()
        }
    }
}
