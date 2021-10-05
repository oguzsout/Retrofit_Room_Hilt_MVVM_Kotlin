package com.oguzdogdu.retrofit_room_hilt_mvvm_kotlin.service

import com.oguzdogdu.retrofit_room_hilt_mvvm_kotlin.model.GithubModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitAPI {
    @GET("repositories")
    fun getDataFromAPI(@Query("q") query: String): Call<GithubModel>
}