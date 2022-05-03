package com.example.hilt.domain.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hilt.domain.model.UserModel
import com.example.hilt.domain.network.Api

class ApiRepository(private val api: Api) {
    private val TAG = ApiRepository::class.java.simpleName

    fun getObservableUsers() = api.getObservableUsers()
}