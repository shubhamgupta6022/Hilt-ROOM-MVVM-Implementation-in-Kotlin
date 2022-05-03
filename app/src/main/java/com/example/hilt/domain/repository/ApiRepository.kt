package com.example.hilt.domain.repository

import com.example.hilt.domain.model.UserModel
import com.example.hilt.domain.network.ApiService
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

interface ApiRepository {

    fun getObservableUsers(): Observable<UserModel>

}