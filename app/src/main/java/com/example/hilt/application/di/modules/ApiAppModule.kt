package com.example.hilt.application.di.modules

import com.example.hilt.data.api.ProfileApiService
import com.example.hilt.data.api.Retrofit
import com.example.hilt.data.repository.profile.ProfileRepositoryImpl
import com.example.hilt.domain.repository.profile.ProfileRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ApiAppModule {

    @Provides
    fun providesApi(): ProfileApiService {
        return Retrofit.PROFILE_API
    }

    @Provides
    fun providesRepository(): ProfileRepository {
        return ProfileRepositoryImpl(providesApi())
    }

}