package com.example.hilt.presentation.viewmodel.user

import androidx.lifecycle.*
import com.example.hilt.core.model.User
import com.example.hilt.domain.repository.user.UserRepository
import com.example.hilt.domain.usecase.user.UserUseCases
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserViewModel @Inject constructor(
    private val userUseCases: UserUseCases
) : ViewModel() {

    private val TAG = UserViewModel::class.java.simpleName

    val usersList : Flow<List<User>> = userUseCases.getAllUsersUseCase()

    fun insert(user: User) {
        userUseCases.insertUserUseCase(user = user)
    }

    suspend fun getUid(email: String, password: String): Int? {
        return userUseCases.getUidUseCase(email = email, password = password)
    }

}