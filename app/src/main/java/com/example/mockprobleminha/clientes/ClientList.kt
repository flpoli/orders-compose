package com.example.mockprobleminha.clientes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ClientScreen(
    onAddClick: () -> Unit,
    vm: ClientListViewModel = hiltViewModel()
) {

    val state = remember { vm.state }
    LazyColumn(){
        items(state.listClient){
            client -> ClientInfoBox(client = client)
        }
    }
}

@Composable
fun ClientInfoBox(client: ClientModel) {

    Column(
        modifier = Modifier
            .border(BorderStroke(1.dp, Color.LightGray), RoundedCornerShape(8.dp))
            .fillMaxSize()
    ) {

        Text(text = "nome: ${client.nome}")
        Text(text = "cpf: ${client.cpf}")

    }

}