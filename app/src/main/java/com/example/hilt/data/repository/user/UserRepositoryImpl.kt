package com.example.hilt.data.repository.user

import com.example.hilt.data.datasource.user.UserDb
import com.example.hilt.data.datasource.user.UserDao
import com.example.hilt.core.model.User
import com.example.hilt.domain.repository.user.UserRepository
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