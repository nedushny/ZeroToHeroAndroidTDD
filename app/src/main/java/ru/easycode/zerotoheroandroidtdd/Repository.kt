package ru.easycode.zerotoheroandroidtdd

/**
 * Created by nedushny on 16.11.2023
 */
interface Repository {

    suspend fun load(): SimpleResponse

    class Base(
        private val service: SimpleService,
        private val url: String
    ) : Repository {
        override suspend fun load(): SimpleResponse {
            val response = service.fetch(url)
            return response
        }
    }
}