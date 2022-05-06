package com.example.hilt.data.datasource.user

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hilt.domain.model.User

@Database(entities = [User::class], version = 1)
abstract class UserDb : RoomDatabase() {
    abstract fun userDao(): UserDao

}