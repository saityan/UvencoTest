package saityan.misc.uvencotest.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import saityan.misc.uvencotest.model.CoffeeCup
import saityan.misc.uvencotest.model.Repository

class EditViewModel @AssistedInject constructor(
    private val repository: Repository,
    @Assisted private val cupId: Int
) : ViewModel() {

    private val _cup = MutableStateFlow<CoffeeCup?>(null)
    val cup: StateFlow<CoffeeCup?> get() = _cup

    init {
        viewModelScope.launch {
            repository.getCupById(cupId).collect {
                _cup.value = it
            }
        }
    }

    private val _areChangesPending = MutableStateFlow(false)
    val areChangesPending: StateFlow<Boolean> get() = _areChangesPending

    fun setChangesPending(pending: Boolean) {
        _areChangesPending.value = pending
    }

    fun updateCup(newCup: CoffeeCup) {
        _cup.value = newCup
    }

    fun saveCup() {
        viewModelScope.launch {
            _cup.value?.let {
                repository.addCup(it)
            }
            _areChangesPending.value = false
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(cupId: Int): EditViewModel
    }

    companion object {
        fun provideEditViewModelFactory(
            factory: Factory,
            cupId: Int
        ): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return factory.create(cupId) as T
                }
            }
        }
    }
}