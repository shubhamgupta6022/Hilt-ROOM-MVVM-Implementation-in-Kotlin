package com.example.hilt.domain.repository

import com.example.hilt.domain.model.UserModel
import io.reactivex.rxjava3.core.Observable

interface ApiRepository {

    fun getObservableUsers(): Observable<UserModel>

}