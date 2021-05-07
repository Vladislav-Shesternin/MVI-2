package com.example.mvi.domain.interactors

import com.example.mvi.domain.repositories.DataRepo
import com.example.mvi.main.MainEvent
import com.example.mvi.main.MainState
import com.example.mvi.mvi.BaseInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

class GetDataInteractor(
    private val repo: DataRepo
) : BaseInteractor<MainEvent, MainState> {

    override fun invoke(event: Flow<MainEvent>, state: Flow<MainState>): Flow<MainEvent> {
        return event.filterIsInstance<MainEvent.GetData>()
            .map {
                delay(1500)
                MainEvent.Success(repo.getData())
            }.flowOn(Dispatchers.Default)
    }

}