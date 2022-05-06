package com.example.hilt.domain.usecase.user

import com.example.hilt.domain.repository.user.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetUidUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend operator fun invoke(email: String, password: String): Int? {
        val uid = withContext(Dispatchers.IO) {
            userRepository.getUid(email = email, password = password)
        }
        return uid
    }
}