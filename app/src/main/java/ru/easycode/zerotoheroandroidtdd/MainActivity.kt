package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var rootLayout: LinearLayout
    private lateinit var titleTextView: TextView
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rootLayout = findViewById(R.id.rootLayout)
        titleTextView = findViewById(R.id.titleTextView)
        button = findViewById(R.id.removeButton)

        savedInstanceState?.let {
            if (!it.getBoolean("isTitleTextViewExist"))
                rootLayout.removeView(titleTextView)
            button.isEnabled = it.getBoolean("isButtonEnabled")
        }

        button.setOnClickListener {
            rootLayout.removeView(titleTextView)
            button.isEnabled = false
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(
            "isTitleTextViewExist",
            findViewById<TextView>(R.id.titleTextView) != null
        )
        outState.putBoolean("isButtonEnabled",button.isEnabled)
    }
}