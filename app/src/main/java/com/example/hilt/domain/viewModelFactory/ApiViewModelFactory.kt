package com.example.hilt.domain.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hilt.domain.repository.ApiRepository
import com.example.hilt.presentation.ApiViewModel
import javax.inject.Inject

class ApiViewModelFactory @Inject constructor(private val repository: ApiRepository): ViewModelProvider.Factory  {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ApiViewModel(repository) as T
    }

}