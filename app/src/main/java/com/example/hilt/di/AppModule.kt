package com.example.hilt.di

import android.content.Context
import androidx.room.Room
import com.example.hilt.db.UserDao
import com.example.hilt.db.UserDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideDb(@ApplicationContext context: Context): UserDb {
        return Room.databaseBuilder(
            context.applicationContext,
            UserDb::class.java,
            "db"
        )
            .fallbackToDestructiveMigration()
            .build()

    }

    @Provides
    fun provideDao(userDb: UserDb): UserDao {
        return userDb.userDao()
    }

}