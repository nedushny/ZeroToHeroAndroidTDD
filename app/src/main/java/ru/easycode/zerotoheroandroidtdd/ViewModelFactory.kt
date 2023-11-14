package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Created by nedushny on 14.11.2023
 */
class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(
                liveDataWrapper = LiveDataWrapper.Base(),
                repository = Repository.Base()
            ) as T
        }
        return super.create(modelClass)
    }
}