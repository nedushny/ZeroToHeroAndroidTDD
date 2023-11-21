package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.view.forEach
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.actionButton.setOnClickListener {
            val text = binding.inputEditText.text.toString()
            addTextView(text)
            binding.inputEditText.setText("")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val texts = ArrayList<String>()
        binding.contentLayout.forEach {
            (it as? TextView)?.let { view -> texts.add(view.text.toString()) }
        }
        outState.putStringArrayList(KEY, texts)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.getStringArrayList(KEY)?.let { list ->
            list.forEach { text -> addTextView(text) }
        }
    }

    private fun addTextView(inputText: String) {
        val textView = TextView(this)
        textView.text = inputText
        binding.contentLayout.addView(textView)

    }

    companion object {
        private const val KEY = "contentViewKey"
    }
}