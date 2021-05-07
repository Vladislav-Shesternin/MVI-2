package com.example.mvi.domain.repositories

class DataRepoImpl : DataRepo {

    override fun getData(): Int {
        return (1..100).random()
    }

}