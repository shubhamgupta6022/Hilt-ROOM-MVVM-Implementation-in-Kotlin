package com.example.hilt.domain.network


import com.example.hilt.domain.model.UserModel
import io.reactivex.rxjava3.core.Observable

import retrofit2.http.GET

interface Api {

    @GET("api/users")
    fun getObservableUsers(): Observable<UserModel>

}