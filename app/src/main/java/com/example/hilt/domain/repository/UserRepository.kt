package com.example.hilt.domain.repository

import com.example.hilt.data.data_source.UserDao
import com.example.hilt.domain.model.User
import com.example.hilt.data.data_source.UserDb
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import javax.inject.Inject

class UserRepository @Inject constructor(userDb: UserDb) {
    private var userDao: UserDao = userDb.userDao()

    suspend fun insert(user: User) {
        userDao.insert(user)
    }

    fun getAllUsers(): List<User> {
        return userDao.getAllUsers()
    }

    suspend fun getUid(email: String, password: String): Int? {
        return userDao.getUid(email, password)
    }

}