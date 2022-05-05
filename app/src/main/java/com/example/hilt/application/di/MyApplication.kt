package com.example.hilt.application.di

import android.app.Application
import com.example.hilt.data.repository.ApiRepositoryImpl
import com.example.hilt.data.api.ApiService
import com.example.hilt.data.api.Retrofit
import com.example.hilt.application.viewmodelfactory.ApiViewModelFactory
import com.example.hilt.domain.repository.ApiRepository
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MyApplication : Application() {

    @Inject
    lateinit var apiService: ApiService

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        apiService = Retrofit.api
    }
}