package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    private lateinit var titleTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        titleTextView = findViewById(R.id.titleTextView)
        savedInstanceState?.let {
            titleTextView.isVisible = it.getBoolean("isTitleTextViewVisible")
        }
        val changeButton: Button = findViewById(R.id.hideButton)
        changeButton.setOnClickListener {
            titleTextView.isVisible = false
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("isTitleTextViewVisible", titleTextView.isVisible)
    }
}