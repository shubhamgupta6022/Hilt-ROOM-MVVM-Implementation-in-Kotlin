package com.example.hilt.domain.repository.user

import com.example.hilt.core.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun insert(user: User)

    suspend fun getUid(email: String, password: String): Int?

    fun getAllUsers(): List<User>

}