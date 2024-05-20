package saityan.misc.uvencotest.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import saityan.misc.uvencotest.model.CoffeeCup
import saityan.misc.uvencotest.model.Repository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    val cups: Flow<List<CoffeeCup>> = repository.getAllCups()

    fun getCupById(id: Int): Flow<CoffeeCup> {
        return repository.getCupById(id)
    }
}