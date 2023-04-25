package com.example.mockprobleminha.clientes

class ClientRepositoryImpl: IClientRepository {
    override fun getClients(): List<ClientModel> {
        return listOf(
            ClientModel("Ana", "111111111-11"),
            ClientModel("Bob", "222222222-22"),
            ClientModel("Carlos", "333333333-33"),
            ClientModel("Daniel", "444444444-44"),
            ClientModel("Elisa", "555555555-55")
        )
    }
}