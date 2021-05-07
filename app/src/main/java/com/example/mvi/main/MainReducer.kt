package com.example.mvi.main

import com.example.mvi.mvi.BaseReducer

class MainReducer : BaseReducer<MainEvent, MainState> {

    override val initialState = MainState(
        isLoading = false,
        data = 0
    )

    override fun reduce(event: MainEvent, state: MainState): MainState {
        return when (event) {
            is MainEvent.Default -> {
                state.copy(
                    isLoading = false,
                    data = 0
                )
            }
            is MainEvent.GetData -> {
                state.copy(
                    isLoading = true
                )
            }
            is MainEvent.Success -> {
                state.copy(
                    isLoading = false,
                    data = event.data
                )
            }
            else -> {
                state
            }
        }
    }
}
