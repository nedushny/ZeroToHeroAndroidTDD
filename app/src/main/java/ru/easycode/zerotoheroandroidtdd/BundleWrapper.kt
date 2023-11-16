package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import android.os.Bundle

/**
 * Created by nedushny on 16.11.2023
 */
interface BundleWrapper {

    class Base(
        private val bundle: Bundle
    ) : Mutable {
        override fun save(uiState: UiState) {
            bundle.putSerializable(KEY_UI_STATE, uiState)
        }

        override fun restore(): UiState {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                bundle.getSerializable(KEY_UI_STATE, UiState::class.java) as UiState
            } else {
                bundle.getSerializable(KEY_UI_STATE) as UiState
            }
        }
    }

    interface Mutable : Save, Restore

    interface Save {
        fun save(uiState: UiState)
    }

    interface Restore {
        fun restore(): UiState
    }

    companion object {
        const val KEY_UI_STATE = "UI_STATE"
    }
}