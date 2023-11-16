package ru.easycode.zerotoheroandroidtdd

import android.app.Application
import android.util.Log

/**
 * Created by nedushny on 16.11.2023
 */
class App : Application() {

    init {
        Log.e("TAG", "app init", )
    }

    lateinit var viewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()
        viewModel = MainViewModel(LiveDataWrapper.Base(), Repository.Base(
            service = SimpleService.create(),
            url = "https://raw.githubusercontent.com/JohnnySC/ZeroToHeroAndroidTDD/task/018-clouddatasource/app/sampleresponse.json"
        ))
    }
}