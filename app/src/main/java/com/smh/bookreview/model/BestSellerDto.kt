package com.smh.bookreview.model

import com.google.gson.annotations.SerializedName

class BestSellerDto(
    @SerializedName("title") val title: String,
    @SerializedName("item") val books: List<Book>
)