package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val titleTextView: TextView? = findViewById(R.id.titleTextView)
        val rootLayout: LinearLayout = findViewById(R.id.rootLayout)
        savedInstanceState?.let {
            if (!it.getBoolean("isTitleTextViewExist"))
                rootLayout.removeView(titleTextView)
        }
        val button: Button = findViewById(R.id.removeButton)
        button.setOnClickListener {
            rootLayout.removeView(titleTextView)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(
            "isTitleTextViewExist",
            findViewById<TextView>(R.id.titleTextView) != null
        )
    }
}