package com.example.mockprobleminha.clientes

data class ClientUiState(
    val selectedClient: ClientModel? = null,
    val listClient: List<ClientModel> = emptyList()
)