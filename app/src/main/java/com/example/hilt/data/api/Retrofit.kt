package com.example.hilt.data.api

import com.example.hilt.core.utils.profile.ProfileApiBaseUrl
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {
    private val retrofit = Retrofit.Builder()
        .baseUrl(ProfileApiBaseUrl.baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    val PROFILE_API: ProfileApiService = retrofit.create(ProfileApiService::class.java)
}