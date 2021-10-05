package com.oguzdogdu.retrofit_room_hilt_mvvm_kotlin.di

import android.app.Application
import com.oguzdogdu.retrofit_room_hilt_mvvm_kotlin.db.AppDao
import com.oguzdogdu.retrofit_room_hilt_mvvm_kotlin.db.AppDatabase
import com.oguzdogdu.retrofit_room_hilt_mvvm_kotlin.service.RetrofitAPI
import com.oguzdogdu.retrofit_room_hilt_mvvm_kotlin.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun getAppDatabase(context: Application): AppDatabase {
        return AppDatabase.getAppDBInstance(context)
    }

    @Provides
    @Singleton
    fun getAppDao(appDatabase: AppDatabase): AppDao {
        return appDatabase.getAppDao()
    }

    @Singleton
    @Provides
    fun injectRetrofitAPI(): RetrofitAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL).build().create(RetrofitAPI::class.java)
    }

}