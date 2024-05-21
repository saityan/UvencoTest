package saityan.misc.uvencotest.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import saityan.misc.uvencotest.model.CoffeeCup
import saityan.misc.uvencotest.model.Repository
import javax.inject.Inject

@HiltViewModel
class EditViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val _cup = MutableStateFlow<CoffeeCup?>(null)
    val cup: StateFlow<CoffeeCup?> get() = _cup

    fun loadCupById(id: Int) {
        viewModelScope.launch {
            repository.getCupById(id).collect {
                _cup.value = it
            }
        }
    }

    fun updateCup(newCup: CoffeeCup) {
        _cup.value = newCup
    }

    fun saveCup() {
        viewModelScope.launch {
            _cup.value?.let {
                repository.addCup(it)
            }
        }
    }
}