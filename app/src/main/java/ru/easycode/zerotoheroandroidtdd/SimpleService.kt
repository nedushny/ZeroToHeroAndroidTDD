package ru.easycode.zerotoheroandroidtdd

import retrofit2.http.GET
import retrofit2.http.Url

/**
 * Created by nedushny on 17.11.2023
 */
interface SimpleService {

    @GET
    suspend fun fetch(@Url url: String): SimpleResponse
}