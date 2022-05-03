package com.example.hilt.domain.repository

import com.example.hilt.domain.model.User

interface UserRepository {

//    private var userDao: UserDao = userDb.userDao()

    suspend fun insert(user: User)

    suspend fun getUid(email: String, password: String): Int?

}