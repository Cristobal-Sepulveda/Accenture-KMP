package com.example.kmp_example.presentation.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

private const val INITIAL_TEXT = "HomeScreen"
private const val CHANGING_SCREEN = "Cambiando screen"

class HomeViewModel : ViewModel() {

    private val _textInScreen = MutableStateFlow(INITIAL_TEXT)
    val textInScreen = _textInScreen.asStateFlow()

    fun showMessage() {
        _textInScreen.value = CHANGING_SCREEN
    }

    fun resetState() {
        _textInScreen.value = INITIAL_TEXT
    }
}