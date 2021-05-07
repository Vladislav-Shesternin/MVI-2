package com.example.mvi.main

import com.example.mvi.mvi.BaseEvent

sealed class MainEvent: BaseEvent {
    object GetDefault: MainEvent()
    object Default: MainEvent()

    object GetData: MainEvent()
    data class Success(val data: Int): MainEvent()
}