package com.oguzdogdu.retrofit_room_hilt_mvvm_kotlin.repository

import androidx.lifecycle.LiveData
import com.oguzdogdu.retrofit_room_hilt_mvvm_kotlin.db.AppDao
import com.oguzdogdu.retrofit_room_hilt_mvvm_kotlin.model.GithubModel
import com.oguzdogdu.retrofit_room_hilt_mvvm_kotlin.model.GithubModelItem
import com.oguzdogdu.retrofit_room_hilt_mvvm_kotlin.service.RetrofitAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RetroRepository @Inject constructor(
    private val retrofitAPI: RetrofitAPI,
    private val appDao: AppDao
) {
    fun getAllRecords(): LiveData<List<GithubModelItem>> {
        return appDao.getAllRecords()
    }

    fun insertRecords(githubModelItem: GithubModelItem) {
        appDao.insertRecords(githubModelItem)
    }


    fun makeApiCall(query: String) {
        val call: Call<GithubModel> = retrofitAPI.getDataFromAPI(query)
        call.enqueue(object : Callback<GithubModel> {
            override fun onResponse(call: Call<GithubModel>, response: Response<GithubModel>) {
                if (response.isSuccessful) {
                    appDao.deleteAllRecords()
                    response.body()?.items?.forEach {
                        insertRecords(it)
                    }
                }
            }

            override fun onFailure(call: Call<GithubModel>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }
}