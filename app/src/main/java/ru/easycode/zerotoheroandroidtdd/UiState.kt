package ru.easycode.zerotoheroandroidtdd

import androidx.core.view.isVisible
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding
import java.io.Serializable

/**
 * Created by nedushny on 15.11.2023
 */
interface UiState : Serializable {

    fun apply(binding: ActivityMainBinding)

    abstract class Abstract(
        private val isButtonEnabled: Boolean,
        private val isProgressVisible: Boolean,
    ) : UiState {
        override fun apply(binding: ActivityMainBinding) {
            binding.progressBar.isVisible = isProgressVisible
            binding.actionButton.isEnabled = isButtonEnabled
        }
    }

    object ShowProgress : Abstract(isButtonEnabled = false, isProgressVisible = true)

    object ShowData : Abstract(isButtonEnabled = true, isProgressVisible = false) {
        override fun apply(binding: ActivityMainBinding) {
            super.apply(binding)
            binding.titleTextView.isVisible = true
        }
    }

}