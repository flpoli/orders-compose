package com.example.mockprobleminha.produtos

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ProductScreen(
    onAddClick: (List<ProductModel>) -> Unit,
    vm: ProductListViewModel = hiltViewModel()
) {

    val state = vm.state // why "remember" wont work here? delegation on vm?

    LazyColumn(
        contentPadding = PaddingValues(16.dp)
    ) {
        items(state.selectableProduct) { product ->
            ProductInfoBox(
                selectableProduct = product,
                onSelectProduct = { vm.onProductChecked(product.product) }
            )

        }
        item {
            Button(onClick = {
                onAddClick(state.selectableProduct.filter { it.isSelected }.map { it.product })
            }) {
                Text(text = "finalizar seleção")
            }
        }
    }
}


@Composable
fun ProductInfoBox(
    selectableProduct: SelectableProductUiState,
    onSelectProduct: (Boolean) -> Unit
) {

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ){

        Checkbox(
            checked = selectableProduct.isSelected ,
            onCheckedChange = onSelectProduct
        )

        Column(
            modifier = Modifier
                .padding(8.dp)
                .border(BorderStroke(1.dp, Color.LightGray), RoundedCornerShape(8.dp))
                .fillMaxSize()
        ) {
            Text(text = "código: ${selectableProduct.product.codigo}", modifier = Modifier.padding(4.dp))
            Text(text = "descrição: ${selectableProduct.product.descricao}", modifier = Modifier.padding(4.dp))
        }

    }
}