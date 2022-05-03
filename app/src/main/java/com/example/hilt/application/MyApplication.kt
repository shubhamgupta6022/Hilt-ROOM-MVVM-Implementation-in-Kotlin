package com.example.hilt.application

import android.app.Application
import com.example.hilt.domain.network.ApiService
import com.example.hilt.domain.network.Retrofit
import com.example.hilt.domain.repository.ApiRepository
import com.example.hilt.domain.viewModelFactory.ApiViewModelFactory
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MyApplication : Application() {
    @Inject
    lateinit var apiRepository: ApiRepository

    @Inject
    lateinit var apiViewModelFactory: ApiViewModelFactory

    @Inject
    lateinit var apiService: ApiService

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        apiService = Retrofit.api
        apiRepository = ApiRepository(apiService)
        apiViewModelFactory = ApiViewModelFactory(apiRepository)
    }
}