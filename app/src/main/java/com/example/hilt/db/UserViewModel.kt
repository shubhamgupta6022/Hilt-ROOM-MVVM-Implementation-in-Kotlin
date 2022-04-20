package com.example.hilt.db

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val repository: UserRepository) : ViewModel() {

    fun insert(user: User) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(user)
    }

    fun getAllUsers() = viewModelScope.launch(Dispatchers.IO) {
        repository.getAllUsers()
    }

    suspend fun getUid(email: String, password: String): Int? {
        val uid = viewModelScope.async(Dispatchers.IO) {
            repository.getUid(email, password)
        }.await()
        return uid
    }

}