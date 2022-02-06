package com.example.categories.response

data class MainResponse(
    var categories: List<Category>,
    var msg: String,
    var status: Boolean
)