package com.example.hilt.presentation.viewmodel.profile

import android.util.Log
import androidx.lifecycle.*
import com.example.hilt.core.model.Data
import com.example.hilt.domain.repository.profile.ProfileRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class ProfileViewModel() : ViewModel() {
    private var observableList = MutableLiveData<List<Data>>()
    private val TAG = ProfileViewModel::class.java.simpleName

    @Inject
    lateinit var repository: ProfileRepository

    init {
        observableList = getUserListObserver()
    }

    val obsList: LiveData<List<Data>>
        get() = observableList

    private fun getUserListObserver(): MutableLiveData<List<Data>> {
        makeApiCall()
        return observableList
    }

    private fun getObservableUsers() = repository.getObservableUsers()

    private fun makeApiCall() {
        getObservableUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ it ->
                Log.d(TAG, "${it.data}")
                observableList.postValue(it.data)
            }, { t ->
                Log.d(TAG, "${t.message}")
            })
    }

}