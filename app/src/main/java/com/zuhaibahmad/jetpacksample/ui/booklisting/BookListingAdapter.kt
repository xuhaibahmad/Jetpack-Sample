package com.zuhaibahmad.jetpacksample.ui.booklisting

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jakewharton.rxbinding2.view.RxView
import com.zuhaibahmad.jetpacksample.R
import io.reactivex.subjects.PublishSubject

class BookListingAdapter(
    val books: MutableList<Book> = mutableListOf()
) : RecyclerView.Adapter<BookListingAdapter.ViewHolder>() {

    val clicks: PublishSubject<Book> = PublishSubject.create<Book>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.book_list_item, parent, false)
    )

    override fun getItemCount(): Int = books.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(books[position])
        RxView.clicks(holder.itemView).map { books[position] }.subscribe(clicks)
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        clicks.onComplete()
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(book: Book) {
            view.findViewById<TextView>(R.id.name).text = book.name
        }
    }
}
