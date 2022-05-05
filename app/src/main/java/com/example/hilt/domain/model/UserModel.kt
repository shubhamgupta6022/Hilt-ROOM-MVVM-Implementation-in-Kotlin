package com.example.hilt.domain.model

import com.example.hilt.core.model.Data

data class UserModel(
    val data: List<Data>,
    val page: Int,
    val per_page: Int,
    val support: Support,
    val total: Int,
    val total_pages: Int
)