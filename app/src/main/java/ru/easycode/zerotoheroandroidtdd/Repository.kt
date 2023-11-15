package ru.easycode.zerotoheroandroidtdd

import kotlinx.coroutines.delay

/**
 * Created by nedushny on 15.11.2023
 */
interface Repository {

    suspend fun load()

    class Base : Repository {
        override suspend fun load() {
            delay(3000)
        }
    }
}