package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.easycode.zerotoheroandroidtdd.databinding.TextListItemBinding

class SimpleTextAdapter : RecyclerView.Adapter<SimpleTextAdapter.ViewHolder>() {

    private var items = arrayListOf<String>()

    fun addItem(text: String) {
        items.add(text)
        notifyItemInserted(items.lastIndex)
    }

    fun save(bundle: Bundle) {
        bundle.putStringArrayList(KEY, items)
    }

    fun restore(bundle: Bundle) {
        items.addAll(bundle.getStringArrayList(KEY) ?: emptyList())
        notifyItemRangeInserted(0, items.size)
    }

    companion object {
        private const val KEY = "recyclerState"
    }

    class ViewHolder(
        private val binding: TextListItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(text: String) {
            binding.elementTextView.text = text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        binding = TextListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}
