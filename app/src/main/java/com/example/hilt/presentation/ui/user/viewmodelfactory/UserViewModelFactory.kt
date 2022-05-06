package com.example.hilt.presentation.ui.user.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hilt.domain.repository.user.UserRepository
import com.example.hilt.presentation.viewmodel.user.UserViewModel
import javax.inject.Inject

class UserViewModelFactory@Inject constructor(private val userRepository: UserRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(userRepository) as T
    }
}