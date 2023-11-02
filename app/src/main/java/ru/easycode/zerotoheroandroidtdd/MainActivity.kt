package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var rootLayout: LinearLayout
    private lateinit var countTextView: TextView
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rootLayout = findViewById(R.id.rootLayout)
        countTextView = findViewById(R.id.countTextView)
        button = findViewById(R.id.incrementButton)

        savedInstanceState?.let {
            countTextView.text = it.getString("countTextViewState")
        }

        button.setOnClickListener {
            countTextView.text = Count.Base(2).increment(countTextView.text.toString())
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(
            "countTextViewState", countTextView.text.toString()
        )
    }
}