package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable

/**
 * Created by nedushny on 13.11.2023
 */
interface UiState : Serializable {

    fun apply(textView: TextView, incrementButton: Button, decrementButton: Button)

    abstract class Abstract(
        private val text: String,
        private val isIncrementButtonEnabled: Boolean,
        private val isDecrementButtonEnabled: Boolean,
    ) : UiState {
        override fun apply(textView: TextView, incrementButton: Button, decrementButton: Button) {
            textView.text = text
            incrementButton.isEnabled = isIncrementButtonEnabled
            decrementButton.isEnabled = isDecrementButtonEnabled
        }
    }
    data class Base(
        private val text: String
    ) : Abstract(text, true, true) {
        override fun apply(textView: TextView, incrementButton: Button, decrementButton: Button) {
            super.apply(textView, incrementButton, decrementButton)
        }
    }

    data class Min(
        private val text: String
    ) : Abstract(text, true, false) {
        override fun apply(textView: TextView, incrementButton: Button, decrementButton: Button) {
            super.apply(textView, incrementButton, decrementButton)
        }
    }

    data class Max(
        private val text: String
    ) : Abstract(text, false, true) {
        override fun apply(textView: TextView, incrementButton: Button, decrementButton: Button) {
            super.apply(textView, incrementButton, decrementButton)
        }
    }
}
