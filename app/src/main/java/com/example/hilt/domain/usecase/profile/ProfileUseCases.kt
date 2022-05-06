package com.example.hilt.domain.usecase.profile

import javax.inject.Inject

data class ProfileUseCases @Inject constructor(
    val getObservableUsersUseCase: GetObservableUsersUseCase
)
