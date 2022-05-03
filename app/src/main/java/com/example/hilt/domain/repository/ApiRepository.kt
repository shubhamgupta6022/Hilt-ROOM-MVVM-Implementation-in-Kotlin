package com.example.hilt.domain.repository

import com.example.hilt.domain.network.ApiService
import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiService: ApiService) {
    private val TAG = ApiRepository::class.java.simpleName

    fun getObservableUsers() = apiService.getObservableUsers()
}