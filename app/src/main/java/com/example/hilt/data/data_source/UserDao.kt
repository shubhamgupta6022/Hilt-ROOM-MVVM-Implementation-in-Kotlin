package com.example.hilt.data.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hilt.domain.model.User
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Query("SELECT * FROM User")
    fun getAllUsers(): List<User>

    @Query("SELECT uid FROM User WHERE emailId LIKE :email AND password LIKE :password")
    suspend fun getUid(email: String, password: String): Int?

}