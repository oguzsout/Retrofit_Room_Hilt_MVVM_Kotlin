package com.oguzdogdu.retrofit_room_hilt_mvvm_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oguzdogdu.retrofit_room_hilt_mvvm_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}