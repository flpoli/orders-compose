package com.example.mockprobleminha.clientes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ClientScreen(
    onAddClick: (ClientModel) -> Unit,
    vm: ClientListViewModel = hiltViewModel()
) {

    val state = remember { vm.state }
    LazyColumn(
        contentPadding = PaddingValues(12.dp)
    ) {
        items(state.listClient) { client ->
            ClientInfoBox(
                client = client,
                onAddClick = onAddClick
            )
        }
    }
}

@Composable
fun ClientInfoBox(
    client: ClientModel,
    onAddClick: (ClientModel) -> Unit,
) {

    Column(
        modifier = Modifier
            .padding(8.dp)
            .border(BorderStroke(1.dp, Color.LightGray), RoundedCornerShape(8.dp))
            .fillMaxSize()
            .clickable { onAddClick(client) }
    ) {

        Text(text = "nome: ${client.nome}", modifier = Modifier.padding(4.dp))
        Text(text = "cpf: ${client.cpf}", modifier = Modifier.padding(4.dp))

    }

}