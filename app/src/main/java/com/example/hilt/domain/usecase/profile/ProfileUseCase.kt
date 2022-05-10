package com.example.hilt.domain.usecase.profile

import javax.inject.Inject

data class ProfileUseCase @Inject constructor(
    val getObservableUsersUseCase: GetObservableUsersUseCase
)