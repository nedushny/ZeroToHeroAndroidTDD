package ru.easycode.zerotoheroandroidtdd

import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding
import java.io.Serializable

interface UiState : Serializable {

    fun apply(binding: ActivityMainBinding)

    class Base(
        private val inputText: String? = null,
        private val text: String
    ) : UiState {
        override fun apply(binding: ActivityMainBinding) {
            binding.titleTextView.text = text
            binding.inputEditText.setText(inputText)
        }
    }
}
