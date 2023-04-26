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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Checkbox
import androidx.compose.ui.Alignment


@Composable
fun ProductScreen(
    onAddClick: () -> Unit,
    vm: ProductListViewModel = hiltViewModel()
    ) {

    val state = remember { vm.state }

    LazyColumn(
        contentPadding = PaddingValues(16.dp)
    ){
        items(state.allProducts){
                product -> ProductInfoBox(
                    selectableProduct = product
        ) { vm.onProductChecked(product = product) }
        }
    }

}


@Composable
fun ProductInfoBox(
    selectableProduct: ProductModel,
    onSelectProduct: (ProductModel) -> Unit
) {

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ){

        // buguei aqui 🥵
        Checkbox(
            checked = selectableProduct.isSelected ,
            onCheckedChange = {
                onSelectProduct(selectableProduct)
            }
        )

        Column(
            modifier = Modifier
                .padding(8.dp)
                .border(BorderStroke(1.dp, Color.LightGray), RoundedCornerShape(8.dp))
                .fillMaxSize()
        ) {
            Text(text = "código: ${selectableProduct.descricao}", modifier = Modifier.padding(4.dp))
            Text(text = "descrição: ${selectableProduct.descricao}", modifier = Modifier.padding(4.dp))
        }

    }


}