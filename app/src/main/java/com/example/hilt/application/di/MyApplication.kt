package com.example.hilt.application.di

import android.app.Application
import com.example.hilt.data.api.ProfileApiService
import com.example.hilt.data.api.Retrofit
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MyApplication : Application() {

    @Inject
    lateinit var profileApiService: ProfileApiService

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        profileApiService = Retrofit.PROFILE_API
    }
}