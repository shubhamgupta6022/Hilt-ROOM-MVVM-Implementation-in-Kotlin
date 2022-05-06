package com.example.hilt.domain.usecase.user

import com.example.hilt.domain.model.User
import com.example.hilt.domain.repository.user.UserRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class GetAllUsersUseCase @Inject constructor(private val userRepository: UserRepository) {
    private val TAG = GetAllUsersUseCase::class.java.simpleName

    operator fun invoke(): Flow<List<User>> = flow {
        while (true) {
            val users = userRepository.getAllUsers()
            emit(users)
            delay(5000)
        }

    }

}