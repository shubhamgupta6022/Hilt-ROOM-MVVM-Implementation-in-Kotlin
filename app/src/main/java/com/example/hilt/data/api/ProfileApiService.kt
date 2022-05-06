package com.example.hilt.data.api


import com.example.hilt.data.api.dto.UserModel
import io.reactivex.rxjava3.core.Observable

import retrofit2.http.GET

interface ProfileApiService {

    @GET("api/users")
    fun getObservableUsers(): Observable<UserModel>

}