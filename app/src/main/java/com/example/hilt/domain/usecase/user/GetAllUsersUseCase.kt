package com.example.hilt.domain.usecase.user

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.hilt.core.model.User
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