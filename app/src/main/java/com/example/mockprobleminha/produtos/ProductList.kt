package com.example.mockprobleminha.produtos

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Checkbox


@Composable
fun ProductScreen(
    onAddClick: () -> Unit,
    vm: ProductListViewModel = hiltViewModel()
    ) {

    val state = remember { vm.state }

    LazyColumn(){
        items(state.allProducts){
                product -> ProductInfoBox(product = product)
        }

    }

}


@Composable
fun ProductInfoBox(product: ProductModel) {

    Row(
        modifier = Modifier.fillMaxWidth()
    ){

//        Checkbox(checked = , onCheckedChange = )

        Column(
            modifier = Modifier
                .border(BorderStroke(1.dp, Color.LightGray), RoundedCornerShape(8.dp))
                .fillMaxSize()
        ) {
            Text(text = "código: ${product.codigo}")
            Text(text = "descrição: ${product.descricao}")
        }

    }


}