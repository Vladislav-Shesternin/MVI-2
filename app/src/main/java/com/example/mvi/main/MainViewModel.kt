package com.example.mvi.main

import com.example.mvi.domain.interactors.GetDataInteractor
import com.example.mvi.domain.repositories.DataRepoImpl
import com.example.mvi.mvi.BaseViewModel

class MainViewModel : BaseViewModel<MainEvent, MainState>(
    interactors = setOf(GetDataInteractor(DataRepoImpl())),
    reducer = MainReducer()
) {

    fun getData() {
        setEvent(MainEvent.GetData)
    }

}