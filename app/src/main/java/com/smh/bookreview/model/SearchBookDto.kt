package com.smh.bookreview.model

import com.google.gson.annotations.SerializedName

class SearchBookDto(
    @SerializedName("title") val title: String,
    @SerializedName("item") val books: List<Book>
)