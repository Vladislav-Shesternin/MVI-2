package com.example.mvi.main

import com.example.mvi.mvi.BaseState

data class MainState(
    val isLoading: Boolean,
    val data: Int
) : BaseState

