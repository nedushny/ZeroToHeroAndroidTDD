package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var decrementButton: Button
    private lateinit var textView: TextView
    private lateinit var incrementButton: Button
    private val count: Count = Count.Base(2, 4, 0)
    private var uiState: UiState = count.initial("0")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        decrementButton = findViewById(R.id.decrementButton)
        incrementButton = findViewById(R.id.incrementButton)
        textView = findViewById(R.id.countTextView)

        uiState.apply(textView, incrementButton, decrementButton)
        incrementButton.setOnClickListener {
            uiState = count.increment(textView.text.toString())
            uiState.apply(textView, incrementButton, decrementButton)
        }

        decrementButton.setOnClickListener {
            uiState = count.decrement(textView.text.toString())
            uiState.apply(textView, incrementButton, decrementButton)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY_UI_STATE, uiState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        uiState = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            savedInstanceState.getSerializable(KEY_UI_STATE, UiState::class.java) as UiState
        else
            savedInstanceState.getSerializable(KEY_UI_STATE) as UiState
        uiState.apply(textView, incrementButton, decrementButton)
    }

    companion object {
        private const val KEY_UI_STATE = "UI_STATE"
    }
}