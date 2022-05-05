package com.example.hilt.application.di.modules

import com.example.hilt.data.api.ApiService
import com.example.hilt.data.api.Retrofit
import com.example.hilt.data.repository.ApiRepositoryImpl
import com.example.hilt.domain.repository.ApiRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiAppModule {

    @Provides
    fun providesApi(): ApiService {
        return Retrofit.api
    }

    @Provides
    fun providesRepository(): ApiRepository {
        return ApiRepositoryImpl(providesApi())
    }

}