package com.example.hilt.db

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