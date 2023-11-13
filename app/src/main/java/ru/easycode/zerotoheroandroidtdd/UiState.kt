package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable

/**
 * Created by nedushny on 07.11.2023
 */
interface UiState : Serializable {

    fun apply (textView: TextView, button: Button)

    abstract class Abstract(private val text: String): UiState {
        override fun apply(textView: TextView, button: Button) {
            textView.text = text
        }
    }

    data class Base(private val text: String) : Abstract(text)

    data class Max(private val text: String) : Abstract(text) {
        override fun apply(textView: TextView, button: Button) {
            super.apply(textView, button)
            button.isEnabled = false
        }
    }
}
