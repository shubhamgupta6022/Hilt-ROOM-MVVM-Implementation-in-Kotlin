package com.example.hilt.data.datasource.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hilt.core.model.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Query("SELECT uid FROM User WHERE emailId LIKE :email AND password LIKE :password")
    suspend fun getUid(email: String, password: String): Int?
}