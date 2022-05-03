package com.example.hilt.presentation

import android.util.Log
import androidx.lifecycle.*
import com.example.hilt.domain.model.Data
import com.example.hilt.domain.model.UserModel
import com.example.hilt.domain.network.Retrofit
import com.example.hilt.domain.repository.ApiRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ApiViewModel(private val repository: ApiRepository) : ViewModel() {
    var observableList = MutableLiveData<List<Data>>()
    private val TAG = ApiViewModel::class.java.simpleName

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