package com.example.hilt.domain.repository

import com.example.hilt.core.model.User

interface UserRepository {

    suspend fun insert(user: User)

    suspend fun getUid(email: String, password: String): Int?

}