package com.example.hilt.domain.usecase.profile

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.hilt.domain.model.Data
import com.example.hilt.domain.repository.profile.ProfileRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class GetObservableUsersUseCase @Inject constructor(private val profileRepository: ProfileRepository) {
    private val TAG = GetObservableUsersUseCase::class.java.simpleName

    private var observableList = MutableLiveData<List<Data>>()

    operator fun invoke(): MutableLiveData<List<Data>> {
        makeApiCall()
        return observableList
    }

    private fun getObservableUsers() = profileRepository.getObservableUsers()

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