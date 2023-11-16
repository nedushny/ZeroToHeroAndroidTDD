package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * Created by nedushny on 16.11.2023
 */
interface LiveDataWrapper {

    fun save(bundleWrapper: BundleWrapper.Save)
    fun update(value: UiState)
    fun liveData(): LiveData<UiState>

    class Base(
        private val mutableLiveData: MutableLiveData<UiState> = SingleLiveEvent()
    ) : LiveDataWrapper {

        override fun save(bundleWrapper: BundleWrapper.Save) {
            mutableLiveData.value?.let { bundleWrapper.save(it) }
        }

        override fun update(value: UiState) {
            mutableLiveData.value = value
        }

        override fun liveData(): LiveData<UiState> = mutableLiveData
    }
}