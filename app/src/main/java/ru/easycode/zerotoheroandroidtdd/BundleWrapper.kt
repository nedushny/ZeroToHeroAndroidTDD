package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import android.os.Bundle

/**
 * Created by nedushny on 17.11.2023
 */
interface BundleWrapper {

    fun save(uiState: UiState)
    fun restore(): UiState

    interface Save : BundleWrapper

    interface Restore : BundleWrapper

    interface Mutable : Save, Restore

    class Base(private val bundle: Bundle) : Mutable {

        override fun save(uiState: UiState) {
            bundle.putSerializable(KEY, uiState)
        }

        override fun restore(): UiState {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
                bundle.getSerializable(KEY, UiState::class.java) as UiState
            else
                bundle.getSerializable(KEY) as UiState
        }
    }

    companion object {
        private const val KEY = "uiStateKey"
    }
}