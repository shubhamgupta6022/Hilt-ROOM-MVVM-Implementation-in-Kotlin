package com.example.hilt.domain.usecase.user

import javax.inject.Inject

data class UserUseCases @Inject constructor(
    val getAllUsersUseCase: GetAllUsersUseCase,
    val getUidUseCase: GetUidUseCase,
    val insertUserUseCase: InsertUserUseCase
)
