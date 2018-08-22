package com.zuhaibahmad.jetpacksample.ui.booklisting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.zuhaibahmad.jetpacksample.R
import kotlinx.android.synthetic.main.book_listing_layout.*
import org.koin.android.ext.android.inject
import timber.log.Timber

class BookListingFragment : Fragment(), BookListingView {

    companion object {
        fun newInstance() = BookListingFragment()
    }

    private lateinit var viewModel: BookListingViewModel

    private val viewModelFactory: BookListingViewModelFactory by inject()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, b: Bundle?): View =
        inflater.inflate(R.layout.book_listing_fragment, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders
            .of(this, viewModelFactory)
            .get(BookListingViewModel::class.java)
        viewModel.view = this
        viewModel.subscribeToUiEvents()

        setupRecyclerView()
        initPullToRefresh()
    }

    private fun setupRecyclerView() = booksList.apply {
        layoutManager = LinearLayoutManager(context)
        adapter = viewModel.adapter
        addItemDecoration(
            VerticalSpaceItemDecoration(
                BookListingAdapter.ViewHolder::class.java,
                resources.getDimensionPixelOffset(R.dimen.space_large)
            )
        )
    }

    private fun initPullToRefresh() {
        swipeRefresh.setColorSchemeResources(R.color.colorAccent)
        swipeRefresh.setOnRefreshListener { viewModel.refreshData() }
    }

    override fun showMessage(message: String) = view?.run {
        Snackbar.make(this, message, Snackbar.LENGTH_SHORT).show()
    } ?: Timber.v("No view available")

    override fun showProgress() {
        swipeRefresh.isRefreshing = true
    }

    override fun hideProgress() {
        swipeRefresh.isRefreshing = false
    }
}
