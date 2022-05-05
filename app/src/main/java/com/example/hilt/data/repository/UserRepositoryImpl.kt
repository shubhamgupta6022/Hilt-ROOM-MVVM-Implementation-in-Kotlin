package com.example.hilt.data.repository

import com.example.hilt.data.datasource.UserDb
import com.example.hilt.data.datasource.UserDao
import com.example.hilt.core.model.User
import com.example.hilt.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(userDb: UserDb) : UserRepository {
    private var userDao: UserDao = userDb.userDao()

    override suspend fun insert(user: User) {
        userDao.insert(user)
    }

    override suspend fun getUid(email: String, password: String): Int? {
        return userDao.getUid(email, password)
    }
}