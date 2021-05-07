package com.example.mvi.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.mvi.R
import com.example.mvi.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect

val TAG = "VLAD"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.root.setOnClickListener {
            viewModel.getData()
        }

        lifecycleScope.launchWhenStarted {
            viewModel.state.collect {
                render(it)
            }
        }
    }

    private fun render(state: MainState) {

        Log.i(TAG, "render: $state")

        when (state) {

            MainState(
                isLoading = false,
                data = 0
            ) -> {
                Log.i(TAG, "render: Default")
            }

            MainState(
                isLoading = true,
                data = 0
            ) -> {
                Log.i(TAG, "render: Loading...")
            }

            MainState(
                isLoading = false,
                data = state.data
            ) -> {
                Log.i(TAG, "render: Load data = ${state.data}")
            }
        }
    }
}