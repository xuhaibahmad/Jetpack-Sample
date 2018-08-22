package com.zuhaibahmad.jetpacksample.ui.booklisting

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zuhaibahmad.jetpacksample.R

class BookListingAdapter(
    val books: MutableList<Book> = mutableListOf()
) : RecyclerView.Adapter<BookListingAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.book_list_item, parent, false)
    )

    override fun getItemCount(): Int = books.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(books[position])

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(book: Book) {
            view.findViewById<TextView>(R.id.name).text = book.name
        }
    }
}
