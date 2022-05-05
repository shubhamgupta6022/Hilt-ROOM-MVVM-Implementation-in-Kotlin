package com.example.hilt.data.repository

import com.example.hilt.domain.model.UserModel
import com.example.hilt.data.api.ApiService
import com.example.hilt.domain.repository.ApiRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(private val apiService: ApiService):ApiRepository {
    override fun getObservableUsers(): Observable<UserModel> {
        return apiService.getObservableUsers()
    }
}