package com.example.mockprobleminha.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class Vm1(
    private val savedStateHandle: SavedStateHandle
): ViewModel() {


    val texto2 = savedStateHandle.getStateFlow<String>("nav_key_2", "")


}