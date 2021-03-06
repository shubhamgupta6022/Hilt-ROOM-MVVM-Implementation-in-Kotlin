package com.example.hilt.data.repository.profile

import com.example.hilt.data.api.dto.UserModel
import com.example.hilt.data.api.ProfileApiService
import com.example.hilt.domain.repository.profile.ProfileRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(private val profileApiService: ProfileApiService):
    ProfileRepository {
    override fun getObservableUsers(): Observable<UserModel> {
        return profileApiService.getObservableUsers()
    }
}