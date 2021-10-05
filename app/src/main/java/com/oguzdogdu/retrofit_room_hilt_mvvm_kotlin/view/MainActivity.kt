package com.oguzdogdu.retrofit_room_hilt_mvvm_kotlin.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.oguzdogdu.retrofit_room_hilt_mvvm_kotlin.adapter.RvAdapter
import com.oguzdogdu.retrofit_room_hilt_mvvm_kotlin.databinding.ActivityMainBinding
import com.oguzdogdu.retrofit_room_hilt_mvvm_kotlin.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var rvAdapter: RvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setupRv()
        initViewModel()


    }

    private fun setupRv() {

        rvAdapter = RvAdapter()

        binding.recyclerView.apply {

            adapter = rvAdapter
            layoutManager = LinearLayoutManager(
                this@MainActivity, LinearLayoutManager.VERTICAL,
                false
            )

            setHasFixedSize(true)
        }
    }


    private fun initViewModel() {
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getAllRepository().observe(this, { list ->
            rvAdapter.listGithub = list
        })

        viewModel.makeApiCall()
    }

}