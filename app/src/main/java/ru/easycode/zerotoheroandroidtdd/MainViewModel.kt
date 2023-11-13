package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class MainViewModel(
    private val liveDataWrapper: LiveDataWrapper,
    private val repository: Repository
) : ViewModel() {
    private val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    val liveData = liveDataWrapper.liveData()

    fun load() {
        viewModelScope.launch {
            liveDataWrapper.update(UiState.ShowProgress)
            repository.load()
            liveDataWrapper.update(UiState.ShowData)
        }
    }

}
