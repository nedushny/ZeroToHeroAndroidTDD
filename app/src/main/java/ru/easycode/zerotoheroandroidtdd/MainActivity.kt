package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val textAdapter = SimpleTextAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.adapter = textAdapter

        binding.actionButton.setOnClickListener {
            textAdapter.addItem(binding.inputEditText.text.toString())
            binding.inputEditText.setText("")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        textAdapter.save(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        textAdapter.restore(savedInstanceState)
    }
}