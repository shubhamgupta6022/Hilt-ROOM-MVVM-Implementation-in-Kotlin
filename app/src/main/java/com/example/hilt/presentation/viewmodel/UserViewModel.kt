package com.example.hilt.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.hilt.data.repository.UserRepositoryImpl
import com.example.hilt.core.model.User
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class UserViewModel @AssistedInject constructor(
    private val repository: UserRepositoryImpl,
    @Assisted private val userId: String
) : ViewModel() {

    @AssistedFactory
    interface UserViewModelFactory {
        fun create(userId: String): UserViewModel
    }

    @Suppress("UNCHECKED_CAST")
    companion object {
        fun providesFactory(
            assistedFactory: UserViewModelFactory,
            userId: String
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return assistedFactory.create(userId) as T
            }
        }
    }

    init {
        Log.d("hilt", userId)

    }

    fun insert(user: User) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(user)
    }

    suspend fun getUid(email: String, password: String): Int? {
        val uid = viewModelScope.async(Dispatchers.IO) {
            repository.getUid(email, password)
        }.await()
        return uid
    }

}