package com.example.mvi.mvi

interface BaseReducer<Event: BaseEvent, State: BaseState> {

    val initialState: State

    fun reduce(event: Event, state: State): State

}