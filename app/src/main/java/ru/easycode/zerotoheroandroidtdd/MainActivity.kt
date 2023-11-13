package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    private lateinit var progress: ProgressBar
    private lateinit var textView: TextView
    private lateinit var button: Button
    private lateinit var rootLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progress = findViewById(R.id.progressBar)
        textView = findViewById(R.id.titleTextView)
        button = findViewById(R.id.actionButton)
        rootLayout = findViewById(R.id.rootLayout)

        button.setOnClickListener {
            button.isEnabled = false
            progress.isVisible = true
            Handler(Looper.getMainLooper()).postDelayed({
                textView.isVisible = true
                button.isEnabled = true
                progress.isVisible = false
            }, 3000)
        }
    }

}