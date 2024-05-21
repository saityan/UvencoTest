package saityan.misc.uvencotest.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class TopBarViewModel @Inject constructor() : ViewModel() {
    private val _currentTime = MutableStateFlow(getCurrentTimeInMinutes())
    val currentTime: StateFlow<String> = _currentTime

    private val _randomNumber = MutableStateFlow(90.0f)
    val randomNumber: StateFlow<Float> = _randomNumber

    init {
        updateData()
    }

    private fun updateData() {
        viewModelScope.launch {
            while (true) {
                delay(1000L)
                _currentTime.value = getCurrentTimeInMinutes()
                _randomNumber.value = generateRandomNumber()
            }
        }
    }

    private fun getCurrentTimeInMinutes(): String {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        return String.format("%02d:%02d", hour, minute)
    }

    private fun generateRandomNumber(): Float {
        return Random.nextFloat() * (95.0f - 85.0f) + 85.0f
    }
}