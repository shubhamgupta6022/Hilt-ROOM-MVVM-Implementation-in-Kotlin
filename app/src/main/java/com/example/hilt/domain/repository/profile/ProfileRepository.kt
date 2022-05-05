package com.example.hilt.domain.repository.profile

import com.example.hilt.domain.model.UserModel
import io.reactivex.rxjava3.core.Observable

interface ProfileRepository {

    fun getObservableUsers(): Observable<UserModel>

}