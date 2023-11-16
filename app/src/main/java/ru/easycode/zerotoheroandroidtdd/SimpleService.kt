package ru.easycode.zerotoheroandroidtdd

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * Created by nedushny on 17.11.2023
 */
interface SimpleService {

    @GET
    suspend fun fetch(@Url url: String) : SimpleResponse

    companion object {
        fun create() = Retrofit.Builder()
            .baseUrl("https://google.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SimpleService::class.java)
    }

}