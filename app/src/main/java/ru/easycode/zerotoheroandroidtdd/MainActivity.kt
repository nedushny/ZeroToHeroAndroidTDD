package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private val viewModelFactory by lazy {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                    return MainViewModel(
                        liveDataWrapper = LiveDataWrapper.Base(),
                        repository = Repository.Base()
                    ) as T
                }
                return super.create(modelClass)
            }
        }
    }

    private lateinit var progress: ProgressBar
    private lateinit var button: Button
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progress = findViewById(R.id.progressBar)
        button = findViewById(R.id.actionButton)
        textView = findViewById(R.id.titleTextView)

        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]


        button.setOnClickListener {
            viewModel.load()
        }
        viewModel.liveData.observe(this) { state ->
            when (state) {
                is UiState.ShowProgress -> {
                    button.isEnabled = false
                    progress.isVisible = true
                }
                is UiState.ShowData -> {
                    progress.isVisible = false
                    button.isEnabled = true
                    textView.isVisible = true
                }
            }
        }


    }
}