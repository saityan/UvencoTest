package saityan.misc.uvencotest.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import saityan.misc.uvencotest.model.CoffeeCup
import saityan.misc.uvencotest.model.Repository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    repository: Repository
) : ViewModel() {

    val cups: Flow<List<CoffeeCup>> = repository.getAllCups()
}