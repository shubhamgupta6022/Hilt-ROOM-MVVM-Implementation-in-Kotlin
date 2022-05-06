package com.example.hilt.presentation.viewmodel.user

import android.util.Log
import androidx.lifecycle.*
import com.example.hilt.core.model.User
import com.example.hilt.domain.repository.user.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserViewModel @Inject constructor(
    private val repository: UserRepository,
) : ViewModel() {

    private val TAG = UserViewModel::class.java.simpleName

    var usersList = MutableLiveData<List<User>>()

    init {

        viewModelScope.launch {
            repository.getAllUsers()
                .catch { exception -> notifyError(exception) }
                .collect { user ->
                    usersList.value = user
                }
        }
    }

    val allUsers: LiveData<List<User>>
        get() = usersList

    private fun notifyError(exception: Throwable) {
        Log.d(TAG, "$exception")
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