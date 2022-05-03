package com.example.hilt.presentation

import android.database.Observable
import android.util.Log
import androidx.lifecycle.*
import com.example.hilt.domain.model.User
import com.example.hilt.domain.repository.UserRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class UserViewModel @AssistedInject constructor(
    private val repository: UserRepository,
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

    lateinit var allUsers : Flowable<MutableList<String>>

    init {
        Log.d("hilt", userId)

        viewModelScope.launch {
            allUsers = getAllUsers()
            Log.d("UserViewModel", "$allUsers")
        }

    }

    fun insert(user: User) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(user)
    }

    private suspend fun getAllUsers(): Flowable<MutableList<String>> {
        val list = viewModelScope.async(Dispatchers.IO) {
            repository.getAllUsers()
        }.await()

        var usersList: MutableList<String> = mutableListOf<String>()
        list.forEach { it ->
            usersList.add(it.name)
        }
//        usersList.add
        Log.d("UserViewModel", "${list[1]}")
        return Flowable.fromIterable(listOf(usersList))
    }

    suspend fun getUid(email: String, password: String): Int? {
        val uid = viewModelScope.async(Dispatchers.IO) {
            repository.getUid(email, password)
        }.await()
        return uid
    }

}