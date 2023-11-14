package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible

/**
 * Created by nedushny on 13.11.2023
 */
interface UiState {

    fun apply(textView: TextView, progress: ProgressBar, button: Button)

    abstract class Abstract(
        private val isProgressVisible: Boolean,
        private val isButtonEnabled: Boolean,
    ) : UiState {
        override fun apply(textView: TextView, progress: ProgressBar, button: Button) {
            progress.isVisible = isProgressVisible
            button.isEnabled = isButtonEnabled
        }
    }

    object ShowProgress : Abstract(true, false)

    object ShowData : Abstract(false, true) {
        override fun apply(textView: TextView, progress: ProgressBar, button: Button) {
            super.apply(textView, progress, button)
            textView.isVisible = true
        }
    }
}