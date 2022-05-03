package com.example.hilt.application.di

import com.example.hilt.domain.network.ApiService
import com.example.hilt.domain.network.Retrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiAppModule {

    @Provides
    @Singleton
    fun providesApi(): ApiService {
        return Retrofit.api
    }

}