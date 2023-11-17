package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * Created by nedushny on 17.11.2023
 */
interface LiveDataWrapper {


    interface Save {
        fun save(bundleWrapper: BundleWrapper.Save)
    }
    interface Update {
        fun update(value: UiState)
    }

    interface Observe {
        fun liveData(): LiveData<UiState>
    }

    interface Mutable : Save, Update, Observe

    class Base(
        private val mutableLiveData: MutableLiveData<UiState> = SingleLiveEvent()
    ) : Mutable {
        override fun save(bundleWrapper: BundleWrapper.Save) {
            mutableLiveData.value?.let { bundleWrapper.save(it) }
        }

        override fun update(value: UiState) {
            mutableLiveData.value = value
        }

        override fun liveData(): LiveData<UiState> = mutableLiveData
    }
}