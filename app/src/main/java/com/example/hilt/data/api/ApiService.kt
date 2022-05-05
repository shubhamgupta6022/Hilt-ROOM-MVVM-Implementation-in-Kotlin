package com.example.hilt.data.api


import com.example.hilt.domain.model.UserModel
import io.reactivex.rxjava3.core.Observable

import retrofit2.http.GET

interface ApiService {

    @GET("api/users")
    fun getObservableUsers(): Observable<UserModel>

}