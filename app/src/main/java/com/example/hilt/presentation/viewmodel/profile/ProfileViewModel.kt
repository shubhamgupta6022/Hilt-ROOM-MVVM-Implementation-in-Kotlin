package com.example.hilt.presentation.viewmodel.profile

import android.util.Log
import androidx.lifecycle.*
import com.example.hilt.core.model.Data
import com.example.hilt.domain.repository.profile.ProfileRepository
import com.example.hilt.domain.usecase.profile.GetObservableUsersUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    getObservableUsersUseCase: GetObservableUsersUseCase
) : ViewModel() {
    private var observableList = MutableLiveData<List<Data>>()

    init {
        observableList = getObservableUsersUseCase()
    }

    val obsList: LiveData<List<Data>>
        get() = observableList


}