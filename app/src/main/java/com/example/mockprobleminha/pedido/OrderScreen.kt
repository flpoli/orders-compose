package com.example.mockprobleminha.pedido

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mockprobleminha.clientes.ClientModel
import com.example.mockprobleminha.produtos.ProductModel


@Composable
fun OrderScreen(
    selectedClient: ClientModel?,
    onNavToClientList: () -> Unit,
    onNavToProductList: () -> Unit,
    onNavToDepois: (ClientModel?) -> Unit,
    productList: List<ProductModel>?,
    client: ClientModel?,
    vm: OrderViewModel = viewModel()
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

        ClientSection(
            onNavToClientList = onNavToClientList,
            selectedClient = client,
        )
        ProductSection(
            onNavToProductList = onNavToProductList,
            selectedProducts = productList,
        )

        Button(onClick = { onNavToDepois(client) }) {
            Text(text = "Nav to Depois")
        }
    }
}


@Composable
fun ClientSection(
    onNavToClientList: () -> Unit,
    selectedClient: ClientModel? = null,
) {

    Column() {

        if(selectedClient != null){
            Text(text = "cpf: ${selectedClient.cpf}")
            Text(text = "nome: ${selectedClient.nome}")
        }

        Button(
            onClick = onNavToClientList ) {
            Text(text = "Selecione o cliente")
        }
    }



}

@Composable
fun ProductSection(
    onNavToProductList: () -> Unit,
    selectedProducts: List<ProductModel>? = null
) {


    Column {

        if(selectedProducts.isNullOrEmpty().not()){

            LazyColumn(){

                items(selectedProducts ?: emptyList()) {
                    produtos -> run {
                        Text(text = "código: ${produtos.codigo}")
                        Text(text = "descrição: ${produtos.descricao}")

                    }
                }
            }
        }


        Button(
            onClick = onNavToProductList
        ) {
            Text(text = "Selecione os produtos")
        }
    }

}