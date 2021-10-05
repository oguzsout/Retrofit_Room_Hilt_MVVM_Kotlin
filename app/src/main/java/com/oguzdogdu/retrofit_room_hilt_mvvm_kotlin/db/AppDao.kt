package com.oguzdogdu.retrofit_room_hilt_mvvm_kotlin.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.oguzdogdu.retrofit_room_hilt_mvvm_kotlin.model.GithubModelItem

@Dao
interface AppDao {

    @Query("SELECT * FROM repositories")
    fun getAllRecords(): LiveData<List<GithubModelItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRecords(githubModelItem: GithubModelItem)

    @Query("DELETE FROM repositories")
    fun deleteAllRecords()
}