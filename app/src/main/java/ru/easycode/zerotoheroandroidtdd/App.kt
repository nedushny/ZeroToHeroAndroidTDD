package ru.easycode.zerotoheroandroidtdd

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by nedushny on 17.11.2023
 */
class App : Application() {
    lateinit var viewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://google.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(SimpleService::class.java)

        viewModel = MainViewModel(LiveDataWrapper.Base(), Repository.Base(service, URL))
    }

    companion object {
        private const val URL = "https://raw.githubusercontent.com/JohnnySC/ZeroToHeroAndroidTDD/task/018-clouddatasource/app/sampleresponse.json"
    }
}