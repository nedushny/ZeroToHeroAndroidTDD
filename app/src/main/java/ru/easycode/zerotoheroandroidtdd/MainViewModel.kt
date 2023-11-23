package ru.easycode.zerotoheroandroidtdd

/**
 * Created by nedushny on 22.11.2023
 */
class MainViewModel(private val listLiveDataWrapper: ListLiveDataWrapper) {

    fun liveData() = listLiveDataWrapper.liveData()

    fun add(text: CharSequence) {
        listLiveDataWrapper.add(text)

    }

    fun save(bundleWrapper: BundleWrapper.Save) {
        listLiveDataWrapper.save(bundleWrapper)
    }

    fun restore(bundle: BundleWrapper.Restore) {
        val list = bundle.restore()
        listLiveDataWrapper.update(list)
    }
}