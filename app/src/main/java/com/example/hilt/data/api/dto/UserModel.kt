package com.example.hilt.data.api.dto

import com.example.hilt.domain.model.Data

data class UserModel(
    val data: List<Data>,
    val page: Int,
    val per_page: Int,
    val support: Support,
    val total: Int,
    val total_pages: Int
)