package com.example.hilt.domain.repository.user

import com.example.hilt.domain.model.User

interface UserRepository {

    suspend fun insert(user: User)

    suspend fun getUid(email: String, password: String): Int?

    fun getAllUsers(): List<User>

}