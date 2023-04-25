package com.example.mockprobleminha.clientes

import android.view.View
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientListViewModel @Inject constructor(
    private val repository: IClientRepository,
    private val savedStateHandle: SavedStateHandle

): ViewModel() {

    var state by mutableStateOf(ClientUiState())

    init {
        loadClientList()
    }

    private fun loadClientList(){
        viewModelScope.launch {
            state = state.copy(
                listClient = repository.getClients()
            )
        }
    }

    fun onSelectClient(client: ClientModel){
        savedStateHandle.set("client",client)
    }
}