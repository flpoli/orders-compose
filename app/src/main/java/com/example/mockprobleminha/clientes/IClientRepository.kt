package com.example.mockprobleminha.clientes

interface IClientRepository {
    fun getClients(): List<ClientModel>
}