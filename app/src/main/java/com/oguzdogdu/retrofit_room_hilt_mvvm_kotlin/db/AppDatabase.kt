package com.oguzdogdu.retrofit_room_hilt_mvvm_kotlin.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.oguzdogdu.retrofit_room_hilt_mvvm_kotlin.model.TypeConverterOwner

@Database(entities = [], version = 1, exportSchema = false)
@TypeConverters(TypeConverterOwner::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getAppDao(): AppDao

    companion object {
        private var DB_INSTANCE: AppDatabase? = null

        fun getAppDBInstance(context: Context): AppDatabase {
            if (DB_INSTANCE == null) {
                DB_INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, "app_db")
                    .allowMainThreadQueries().build()
            }
            return DB_INSTANCE!!
        }

    }
}