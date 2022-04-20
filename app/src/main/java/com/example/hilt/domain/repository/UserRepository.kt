package com.example.hilt.domain.repository

import com.example.hilt.data.data_source.UserDao
import com.example.hilt.domain.model.User
import com.example.hilt.data.data_source.UserDb
import javax.inject.Inject

class UserRepository @Inject constructor(userDb: UserDb) {
    private var userDao: UserDao = userDb.userDao()

    suspend fun insert(user: User) {
        userDao.insert(user)
    }

    suspend fun getAllUsers(): List<User> {
        return userDao.getAllUsers()
    }

    suspend fun getUid(email: String, password: String): Int? {
        return userDao.getUid(email, password)
    }

}