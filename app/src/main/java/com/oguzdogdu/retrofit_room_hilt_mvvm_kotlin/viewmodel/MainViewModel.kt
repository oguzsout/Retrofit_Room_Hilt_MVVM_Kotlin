package com.oguzdogdu.retrofit_room_hilt_mvvm_kotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.oguzdogdu.retrofit_room_hilt_mvvm_kotlin.model.GithubModelItem
import com.oguzdogdu.retrofit_room_hilt_mvvm_kotlin.repository.RetroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: RetroRepository) : ViewModel() {

    fun getAllRepository(): LiveData<List<GithubModelItem>> {
        return repository.getAllRecords()
    }

    fun makeApiCall() {
        repository.makeApiCall("ny")
    }
}