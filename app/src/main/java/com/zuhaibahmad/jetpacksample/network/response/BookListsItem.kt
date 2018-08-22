package com.zuhaibahmad.jetpacksample.network.response

import com.google.gson.annotations.SerializedName

data class BookListsItem(

	@field:SerializedName("books")
	val books: List<Book>,

	@field:SerializedName("list_id")
	val listId: Int,

	@field:SerializedName("list_image")
	val listImage: String,

	@field:SerializedName("list_image_height")
	val listImageHeight: Int,

	@field:SerializedName("list_name")
	val listName: String,

	@field:SerializedName("list_name_encoded")
	val listNameEncoded: String,

	@field:SerializedName("display_name")
	val displayName: String,

	@field:SerializedName("updated")
	val updated: String,

	@field:SerializedName("list_image_width")
	val listImageWidth: Int
)