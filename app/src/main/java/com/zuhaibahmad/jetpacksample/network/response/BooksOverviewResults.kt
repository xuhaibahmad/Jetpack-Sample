package com.zuhaibahmad.jetpacksample.network.response

import com.google.gson.annotations.SerializedName

data class BooksOverviewResults(

	@field:SerializedName("next_published_date")
	val nextPublishedDate: String,

	@field:SerializedName("bestsellers_date")
	val bestsellersDate: String,

	@field:SerializedName("published_date_description")
	val publishedDateDescription: String,

	@field:SerializedName("lists")
	val lists: List<BookListsItem>,

	@field:SerializedName("previous_published_date")
	val previousPublishedDate: String,

	@field:SerializedName("published_date")
	val publishedDate: String
)