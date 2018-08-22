package com.zuhaibahmad.jetpacksample.network.response

import com.google.gson.annotations.SerializedName

data class Book(

	@field:SerializedName("contributor_note")
	val contributorNote: String,

	@field:SerializedName("age_group")
	val ageGroup: String,

	@field:SerializedName("author")
	val author: String,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("primary_isbn10")
	val primaryIsbn10: String,

	@field:SerializedName("primary_isbn13")
	val primaryIsbn13: String,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("buy_links")
	val buyLinks: List<BuyLinksItem>,

	@field:SerializedName("sunday_review_link")
	val sundayReviewLink: String,

	@field:SerializedName("article_chapter_link")
	val articleChapterLink: String,

	@field:SerializedName("weeks_on_list")
	val weeksOnList: Int,

	@field:SerializedName("book_image_width")
	val bookImageWidth: Int,

	@field:SerializedName("contributor")
	val contributor: String,

	@field:SerializedName("amazon_product_url")
	val amazonProductUrl: String,

	@field:SerializedName("book_review_link")
	val bookReviewLink: String,

	@field:SerializedName("book_image_height")
	val bookImageHeight: Int,

	@field:SerializedName("price")
	val price: Int,

	@field:SerializedName("book_image")
	val bookImage: String,

	@field:SerializedName("publisher")
	val publisher: String,

	@field:SerializedName("rank")
	val rank: Int,

	@field:SerializedName("created_date")
	val createdDate: String,

	@field:SerializedName("updated_date")
	val updatedDate: String,

	@field:SerializedName("rank_last_week")
	val rankLastWeek: Int,

	@field:SerializedName("first_chapter_link")
	val firstChapterLink: String
)