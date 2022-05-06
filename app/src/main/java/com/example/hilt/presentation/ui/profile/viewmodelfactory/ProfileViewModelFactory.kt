package com.example.hilt.presentation.ui.profile.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hilt.domain.repository.profile.ProfileRepository
import com.example.hilt.domain.usecase.profile.GetObservableUsersUseCase
import com.example.hilt.presentation.viewmodel.profile.ProfileViewModel
import javax.inject.Inject

class ProfileViewModelFactory @Inject constructor(private val getObservableUsersUseCase: GetObservableUsersUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProfileViewModel(getObservableUsersUseCase) as T
    }

}