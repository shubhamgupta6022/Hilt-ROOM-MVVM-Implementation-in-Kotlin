package com.example.hilt.domain.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hilt.data.repository.ApiRepositoryImpl
import com.example.hilt.presentation.ApiViewModel
import javax.inject.Inject

class ApiViewModelFactory @Inject constructor(private val repository: ApiRepositoryImpl): ViewModelProvider.Factory  {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ApiViewModel(repository) as T
    }

}