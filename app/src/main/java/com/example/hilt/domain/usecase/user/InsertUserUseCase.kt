package com.example.hilt.domain.usecase.user

import com.example.hilt.core.model.User
import com.example.hilt.domain.repository.user.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class InsertUserUseCase @Inject constructor(private val userRepository: UserRepository) {
    operator fun invoke(user: User) {
        GlobalScope.launch(Dispatchers.IO) {
            userRepository.insert(user = user)
        }
    }
}