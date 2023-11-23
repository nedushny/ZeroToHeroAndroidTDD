package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface ListLiveDataWrapper {
    fun liveData(): LiveData<List<CharSequence>>
    fun add(new: CharSequence)
    fun save(bundle: BundleWrapper.Save)
    fun update(list: List<CharSequence>)

    class Base(
        private val mutableLiveData: MutableLiveData<List<CharSequence>> = SingleLiveEvent()
    ) : ListLiveDataWrapper {
        override fun liveData(): LiveData<List<CharSequence>> = mutableLiveData

        override fun add(new: CharSequence) {
            val newList = ArrayList(mutableLiveData.value ?: emptyList())
            newList.add(new)
            update(newList)
        }

        override fun save(bundle: BundleWrapper.Save) {
            bundle.save(ArrayList(mutableLiveData.value ?: emptyList()))
        }

        override fun update(list: List<CharSequence>) {
            mutableLiveData.value = list
        }
    }
}

interface BundleWrapper {

    interface Save {
        fun save(list: ArrayList<CharSequence>)
    }

    interface Restore {
        fun restore(): List<CharSequence>
    }

    interface Mutable : Save, Restore

    class Base(
        private val bundle: Bundle
    ) : Mutable {
        override fun save(list: ArrayList<CharSequence>) {
            bundle.putCharSequenceArrayList(KEY, list)
        }

        override fun restore(): List<CharSequence> {
            return bundle.getCharSequenceArrayList(KEY) ?: emptyList()
        }
    }

    companion object {
        private const val KEY = "listKey"
    }
}
