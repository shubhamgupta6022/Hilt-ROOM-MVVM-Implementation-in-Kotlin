package com.example.hilt.presentation.ui.profile.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hilt.domain.usecase.profile.ProfileUseCase
import com.example.hilt.presentation.viewmodel.profile.ProfileViewModel
import javax.inject.Inject

class ProfileViewModelFactory @Inject constructor(private val profileUseCases: ProfileUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProfileViewModel(profileUseCases) as T
    }
}