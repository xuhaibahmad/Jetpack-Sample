package com.zuhaibahmad.jetpacksample.network.response

import com.google.gson.annotations.SerializedName

data class BookReviewResponse(

	@field:SerializedName("copyright")
	val copyright: String,

	@field:SerializedName("results")
	val results: List<BookReviewResults>,

	@field:SerializedName("num_results")
	val numResults: Int,

	@field:SerializedName("status")
	val status: String
)