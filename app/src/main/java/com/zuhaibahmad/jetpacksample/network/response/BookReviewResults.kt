package com.zuhaibahmad.jetpacksample.network.response

import com.google.gson.annotations.SerializedName

data class BookReviewResults(

	@field:SerializedName("summary")
	val summary: String,

	@field:SerializedName("book_title")
	val bookTitle: String,

	@field:SerializedName("isbn13")
	val isbn13: List<String>,

	@field:SerializedName("book_author")
	val bookAuthor: String,

	@field:SerializedName("publication_dt")
	val publicationDt: String,

	@field:SerializedName("byline")
	val byline: String,

	@field:SerializedName("uuid")
	val uuid: String,

	@field:SerializedName("uri")
	val uri: String,

	@field:SerializedName("url")
	val url: String
)