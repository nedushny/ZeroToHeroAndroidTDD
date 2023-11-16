package ru.easycode.zerotoheroandroidtdd

import androidx.core.view.isVisible
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding
import java.io.Serializable

/**
 * Created by nedushny on 16.11.2023
 */
interface UiState : Serializable {

    fun apply(binding: ActivityMainBinding)

    abstract class Abstract(
        private val isButtonEnabled: Boolean,
        private val isProgressVisible: Boolean
    ): UiState {
        override fun apply(binding: ActivityMainBinding) {
            binding.actionButton.isEnabled = isButtonEnabled
            binding.progressBar.isVisible = isProgressVisible
        }
    }

    object ShowProgress : Abstract(false, true)

    data class ShowData(val text: String) : Abstract(true, false) {
        override fun apply(binding: ActivityMainBinding) {
            super.apply(binding)
            binding.titleTextView.isVisible = true
            binding.titleTextView.text = text
        }
    }
}