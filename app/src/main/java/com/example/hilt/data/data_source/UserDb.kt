package com.example.hilt.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hilt.data.data_source.UserDao
import com.example.hilt.domain.model.User

@Database(entities = [User::class], version = 1)
abstract class UserDb : RoomDatabase() {
    abstract fun userDao(): UserDao

//    companion object {
//        private var INSTANCE: UserDb? = null
//
//        fun getInstance(context: Context): UserDb {
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    UserDb::class.java,
//                    "db"
//                )
//                    .fallbackToDestructiveMigration()
//                    .build()
//                INSTANCE = instance
//                // return instance
//                instance
//            }
//        }
//    }
}