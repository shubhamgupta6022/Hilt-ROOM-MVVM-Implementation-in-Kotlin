package com.example.hilt.presentation.viewmodel.profile


import androidx.lifecycle.*
import com.example.hilt.domain.model.Data
import com.example.hilt.domain.usecase.profile.ProfileUseCases
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    profileUseCases: ProfileUseCases
) : ViewModel() {
    private var observableList = MutableLiveData<List<Data>>()

    init {
        observableList = profileUseCases.getObservableUsersUseCase()
    }

    val obsList: LiveData<List<Data>>
        get() = observableList


}