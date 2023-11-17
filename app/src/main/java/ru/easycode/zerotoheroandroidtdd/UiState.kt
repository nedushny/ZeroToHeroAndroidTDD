package ru.easycode.zerotoheroandroidtdd

import androidx.core.view.isVisible
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding
import java.io.Serializable

/**
 * Created by nedushny on 17.11.2023
 */
interface UiState : Serializable {

    fun apply(binding: ActivityMainBinding)

    abstract class Abstract(
        private val isProgressVisible: Boolean,
        private val isButtonEnabled: Boolean,
    ) : UiState {
        override fun apply(binding: ActivityMainBinding) {
            binding.progressBar.isVisible = isProgressVisible
            binding.actionButton.isEnabled = isButtonEnabled
        }
    }

    object ShowProgress : Abstract(true, false)

    data class ShowData(private val text: String) : Abstract(false, true) {
        override fun apply(binding: ActivityMainBinding) {
            super.apply(binding)
            binding.titleTextView.isVisible = true
            binding.titleTextView.text = text
        }
    }
}